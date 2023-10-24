package com.sp.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Image extends Element{
    private String imageName;

    public Image(String imageName) {
        this.imageName = imageName;
    }

    public Image(Image other) {
        this.imageName = other.imageName;
    }
    @Override
    public void print(){
        System.out.println("Image with name:" + this.imageName);
    }

    @Override
    public Element clone() {
        return new Image(this);
    }
}
