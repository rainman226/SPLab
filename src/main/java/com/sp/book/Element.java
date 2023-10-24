package com.sp.book;

import java.util.ArrayList;
import java.util.List;

public abstract class Element {
    protected List<Element> elementList;

    public Element() {
        this.elementList = new ArrayList<>();
    }

    public void add(Element element) {
        elementList.add(element.clone());
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
