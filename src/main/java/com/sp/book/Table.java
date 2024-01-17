package com.sp.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class Table extends Element  implements Visitee {
    private String title;

    public Table(String title) {
        this.title = title;
    }

    public Table(Table other) {
        this.title = other.title;

    }
    @Override
    public void print() {
        System.out.println("Table with Title: " + this.title);
    }

    @Override
    public Element clone() {
        return new Table(this);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitTable(this);
    }
}
