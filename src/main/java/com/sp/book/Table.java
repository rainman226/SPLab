package com.sp.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Table implements Element {
    private String title;

    @Override
    public void print() {
        System.out.println("Table with Title: " + this.title);
    }

    @Override
    public void add(Element element){};

    @Override
    public void remove(Element element){};

    @Override
    public Element get(int index) {
        return null;
    }
}
