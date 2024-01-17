package com.sp.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Author  implements Visitee {
    private String name;
    private String surname;

    public Author() {
        name = "";
        surname = "";
    }

    public Author(String name) {
        this.name = name;
    }

    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Author(Author author){
        this.name = author.name;
        this.surname = author.surname;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitAuthor(this);
    }
}
