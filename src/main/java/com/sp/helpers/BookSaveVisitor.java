package com.sp.helpers;

import com.sp.book.*;

import java.util.List;

public class BookSaveVisitor implements Visitor<Void> {
    private final StringBuilder buildingJson = new StringBuilder();
    private int paragraphLastIndex = 0;
    private int sectionLastIndex = 0;
    private int imageLastIndex = 0;
    private int tableLastIndex = 0;
    private int authorLastIndex = 0;

    @Override
    public Void visitBook(Book book) {
        String BookPropertiesTemplateJson = """
                {
                    "Book": {
                    "title": "%s",
                    "Authors": [
                """;
        buildingJson.append(String.format(BookPropertiesTemplateJson,book.getTitle()));
        for (Author author :
                book.getAuthorList()) {
            author.accept(this);
        }
        buildingJson.append("]");
        buildingJson.append(!book.getElementList().isEmpty() ? "," : "");
        List<Element> books = book.getElementList();
        printChilds(books);
        buildingJson.append("}\n}");
        return null;
    }

    private void printChilds(List<Element> books) {
        for (int i = 0; i < books.size(); i++) {
            books.get(i).accept(this);
            if (i != books.size() - 1) buildingJson.append(",");
        }
    }

    @Override
    public Void visitSection(Section section) {
        String sectionJsonTemplate = """
                "Section %d": {
                    "title": "%s"%s
                """;
        sectionLastIndex++;
        String json = String.format(sectionJsonTemplate, sectionLastIndex,
                section.getTitle(), !section.getElementList().isEmpty() ? ",": "");
        buildingJson.append(json);
        var sections = section.getElementList();
        printChilds(sections);
        buildingJson.append("}");
        return null;
    }

    @Override
    public Void visitTableOfContents(TableOfContents toc) {
        int pageCount = 1;
        String entryTemplate = "\"%s\":\"%s\"";
        buildingJson.append("\"TableOfContent\" : {");
        for (String entry :
                toc.getEntries()) {
            if (entry != null)
                buildingJson.append(String.format(entryTemplate, entry, pageCount));
            else pageCount++;
        }
        buildingJson.append("}");
        return null;
    }

    @Override
    public Void visitParagraph(Paragraph paragraph) {
        String paragraphJsonTemplate = """
                "Paragraph %d": {
                    "text": "%s"
                }
                """;
        paragraphLastIndex++;
        buildingJson.append(String.format(paragraphJsonTemplate, paragraphLastIndex, paragraph.getText()));
        return null;
    }

    @Override
    public Void visitImageProxy(ImageProxy imageProxy) {
        imageProxy.loadImage().accept(this);
        return null;
    }

    @Override
    public Void visitImage(Image image) {
        String imageJsonTemplate = """
                "Image %d": {
                    "name": "%s"
                }
                """;
        imageLastIndex++;
        buildingJson.append(String.format(imageJsonTemplate, imageLastIndex, image.getImageName()));
        return null;
    }

    @Override
    public Void visitTable(Table table) {
        String tableJsonTemplate = """
                "Table %d": {
                    "title": "%s"
                }
                """;
        tableLastIndex++;
        buildingJson.append(String.format(tableJsonTemplate, tableLastIndex, table.getTitle()));
        return null;
    }

    public Void visitAuthor(Author author) {
        String authorJsonTemplate = """
                "Author %d": {
                    "Author": "%s"
                }
                """;
        authorLastIndex++;
        String json = String.format(authorJsonTemplate, authorLastIndex, author.getName());
        buildingJson.append(json);
        return null;
    }

    public String GetJson(){
        return buildingJson.toString();
    }
}