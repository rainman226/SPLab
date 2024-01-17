package com.sp.book;

import com.sp.helpers.AlignLeft;
import com.sp.helpers.AlignStrategy;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Paragraph extends Element implements Visitee {
    private String text;

    public Paragraph() { text = "";}
    public Paragraph(String text) {
        this.text = text;
    }
    public Paragraph(Paragraph other){this.text = other.text;}


    @Override
    public Element clone() {
        return new Paragraph(this);
    }


    @Override
    public void accept(Visitor visitor) {
        visitor.visitParagraph(this);
    }
}
