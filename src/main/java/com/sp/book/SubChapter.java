package com.sp.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SubChapter {
    private String name;
    private List<Image> imageList;
    private List<Paragraph> paragraphList;
    private List<Table> tableList;

    public SubChapter(String name){
        this.name = name;
        this.imageList = new ArrayList<Image>();
        this.paragraphList = new ArrayList<Paragraph>();
        this.tableList = new ArrayList<Table>();
    }

    public void print(){
        System.out.println("Subchapter: " + this.name);
        for(Paragraph p:paragraphList){
            p.print();
        }

        for(Image i:imageList){
            i.print();
        }

        for(Table t:tableList){
            t.print();
        }
    }

    public void createNewParagraph(String name) {
        paragraphList.add(new Paragraph(name));
    }

    public void createNewImage(String name) {
        imageList.add(new Image(name));
    }

    public void createNewTable(String name) {
        tableList.add(new Table(name));
    }
}
