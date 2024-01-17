package com.sp.book;

import com.sp.helpers.AlignLeft;
import com.sp.helpers.AlignStrategy;
import lombok.Getter;
import lombok.Setter;

public class Paragraph extends Element implements Visitee {
    @Getter
    private String text;
    @Setter
    private AlignStrategy alignStrategy;
    public Paragraph(String text) {
        this.text = text;
    }
    public Paragraph(Paragraph other) {
        this.text = other.text;
    }
    @Override
    public void print() {
        if(alignStrategy != null)
            alignStrategy.render(text);
        else new AlignLeft().render(text);
    }

    @Override
    public Element clone() {
        return new Paragraph(this);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitParagraph(this);
    }
}
