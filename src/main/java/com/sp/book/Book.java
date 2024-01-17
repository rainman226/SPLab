package com.sp.book;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Entity
public class Book extends Section implements Visitee {
    @ManyToMany
    private List<Author> authorList;
    public Book(){
        super("");
        authorList = new ArrayList<>();
    }

    public Book(String title) {
        super(title);
        authorList = new ArrayList<>();
    }

    public Book(Book other){
        super(other.title);
        this.authorList = new ArrayList<>(other.authorList);
    }

    public void addAuthor(Author author) {
        this.authorList.add(new Author(author));
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitBook(this);
    }

}
