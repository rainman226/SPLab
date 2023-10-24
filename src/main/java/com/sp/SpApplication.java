package com.sp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sp.book.*;

@SpringBootApplication
public class SpApplication {

	public static void main(String[] args) {
		Book noapteBuna = new Book("Noapte buna, copii!");
		Author rpGheo = new Author("Radu Pavel Gheo");
		Section cap1 = new Section("Capitolul 1");
		Section cap11 = new Section("Capitolul 1.1");
		Section cap111 = new Section("Capitolul 1.1.1");
		Section cap1111 = new Section("Subchapter 1.1.1.1");

		noapteBuna.addAuthor(rpGheo);
		noapteBuna.add(new Paragraph("Multumesc celor care ..."));
		cap1111.add(new Image("Image subchapter 1.1.1.1"));
		cap111.add(new Paragraph("Text from subchapter 1.1.1"));
		cap111.add(cap1111);
		cap11.add(new Paragraph("Text from subchapter 1.1"));
		cap11.add(cap111);
		cap1.add(new Paragraph("Moto capitol"));
		cap1.add(cap11);
		noapteBuna.add(cap1);

		noapteBuna.print();
	}
}
