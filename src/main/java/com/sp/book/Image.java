package com.sp.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.concurrent.TimeUnit;

@Getter
public class Image extends Element implements Visitee {
    @Getter
    private String imageName;

    public Image(String imageName) {
        this.imageName = imageName;
    }
    public Image(Image other){
        imageName = other.imageName;
    }



    @Override
    public void add(Element e) {
        throw new IllegalStateException("Cannot add an element");
    }

    @Override
    public void remove(Element e) {
        throw new IllegalStateException("Cannot remove an element");
    }

    @Override
    public Element get(int index) {
        throw new IllegalStateException("Cannot get an element");
    }

    @Override
    public Element clone() {
        return new Image(this);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitImage(this);
    }
    @Override
    public void print(){
        System.out.println("Image with name:" + this.imageName);
    }

}
