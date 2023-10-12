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
    private List<Chapter> chapterList;

    public Book(String title) {
        this.title = title;
        this.chapterList = new ArrayList<Chapter>(); // Initialize an empty chapter list
        this.authorList = new ArrayList<Author>();
    }

    public void addAuthor(Author authorName){
        authorList.add(authorName);
    }

    public int createChapter(String chapterTitle) {
        Chapter newChapter = new Chapter(chapterTitle);
        chapterList.add(newChapter);
        return chapterList.indexOf(newChapter);
    }

    public Chapter getChapter(int index) {
        if (index >= 0 && index < chapterList.size()) {
            return chapterList.get(index);
        } else {
            return null;
        }
    }

    public void print(){
        System.out.println("Book: " + this.title);
        for(Author a:authorList){
            a.print();
        }

        for(Chapter c:chapterList){
            c.print();
        }
    }
}
