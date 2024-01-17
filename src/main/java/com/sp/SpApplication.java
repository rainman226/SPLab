package com.sp;

import com.sp.components.*;
import com.sp.helpers.BookSaveVisitor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sp.book.*;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpApplication {

	public static void main(String[] args) throws Exception{
//		SpringApplication.run(DesignPatternsLab2023Application.class, args);
		createTableOfContent();

	}

	public static void createTableOfContent() {

		Book b = new Book("The book");
		Section cap1 = new Section("Chapter 1");
		Section cap11 = new Section("Subchapter 1.1");
		Section cap2 = new Section("Chapter 2");
		cap1.add(new Paragraph("Paragraph 1"));
		cap1.add(new Paragraph("Paragraph 2"));
		cap1.add(new Paragraph("Paragraph 3"));

		cap11.add(new ImageProxy("ImageOne"));
		cap11.add(new Image("ImageTwo"));

		cap2.add(new Paragraph("Paragraph 4"));
//        cap2.add(p4);
		cap1.add(cap11);
		cap1.add(new Paragraph("Some text"));
		cap1.add(new Table("Table 1"));
		b.add(cap1);
		b.add(cap2);
//        TableOfContentUpdate tocUpdate = new TableOfContentUpdate();
//        b.accept(tocUpdate);
//        tocUpdate.getToC().accept(new RenderContentVisitor());
		BookSaveVisitor saveVisitor = new BookSaveVisitor();
		b.accept(saveVisitor);
		System.out.println(saveVisitor.GetJson());

	}
}
