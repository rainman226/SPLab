package com.sp.book;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sp.helpers.ElementDeserializer;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@JsonDeserialize(using = ElementDeserializer.class)
public abstract class Element implements Visitee {

    @Setter
    protected List<Element> elementList;
    public Element() {
        this.elementList = new ArrayList<>();
    }

    public void add(Element e) {
        elementList.add(e);
    }
    public void remove(Element e) {
        elementList.remove(e);
    }
    public Element get(int index) {
        return elementList.get(index);
    }

    public abstract Element clone();
}