package com.sp.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Paragraph implements Element{
    private String text;

    @Override
    public void print() {
        System.out.println("Paragraph: " + this.text);
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
