package com.sp.book;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public abstract class Element implements Visitee{
    protected List<Element> elementList;

    public Element() {
        this.elementList = new ArrayList<>();
    }

    public void add(Element element) {
        elementList.add(element);
    }

    public void remove(Element element) {
        elementList.remove(element);
    }

    public Element get(int index) {
        return elementList.get(index);
    }

    public abstract void print();
    public abstract Element clone();
}
