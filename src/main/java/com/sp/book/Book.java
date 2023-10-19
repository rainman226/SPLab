package com.sp.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {
    private String title;
    private List<Author> authorList;
    private List<Element> elementList;

    public Book(String title) {
        this.title = title;
        this.elementList = new ArrayList<Element>(); // Initialize an empty chapter list
        this.authorList = new ArrayList<Author>();
    }

    public void addAuthor(Author authorName){
        authorList.add(authorName);
    }

    public void addContent(Element element){
        elementList.add(element);
    }

    public void print(){
        System.out.println("Book: " + this.title);
        for(Author author:authorList){
            author.print();
        }

        for(Element element: elementList){
            element.print();
        }
    }
}
