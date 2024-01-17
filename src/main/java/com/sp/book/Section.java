package com.sp.book;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


@Getter
public class Section extends Element  implements Visitee {
    protected String title;

    public Section(String title) {
        this.title = title;
        this.elementList = new ArrayList<>();
    }

    public Section(Section other) {
        this.title = other.title;
        this.elementList = new ArrayList<>(other.elementList);
    }
    @Override
    public void print(){
        System.out.println(title);

        for(Element element : elementList) {
            element.print();
        }
    }

    @Override
    public Element clone() {
        return new Section(this);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitSection(this);
    }
}
