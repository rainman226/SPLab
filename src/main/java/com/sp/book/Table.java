package com.sp.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Table extends Element {
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
}
