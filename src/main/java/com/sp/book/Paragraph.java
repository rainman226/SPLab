package com.sp.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Paragraph extends Element{
    private String text;

    public Paragraph(String text) {
        this.text = text;
    }
    public Paragraph(Paragraph other) {
        this.text = other.text;
    }
    @Override
    public void print() {
        System.out.println("Paragraph: " + this.text);
    }

    @Override
    public Element clone() {
        return new Paragraph(this);
    }
}
