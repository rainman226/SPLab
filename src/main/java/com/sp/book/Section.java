package com.sp.book;

import java.util.ArrayList;
import java.util.List;


public class Section implements Element{
    private String title;
    private List<Element> elementList;

    public Section(String title) {
        this.title = title;
        this.elementList = new ArrayList<>();
    }

    @Override
    public void add(Element element) {
        elementList.add(element);
    }

    @Override
    public void remove(Element element) {}

    @Override
    public Element get(int index) {
        return null;
    }

    @Override
    public void print(){
        System.out.println(title);

        for(Element element : elementList) {
            element.print();
        }
    }
}
