package com.sp.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Image implements Element{
    private String imageName;
    @Override
    public void print(){
        System.out.println("Image with name:" + this.imageName);
    }

    @Override
    public void add(Element element){};

    @Override
    public void remove(Element element){};

    @Override
    public Element get(int index) {
        return null;
    }
}
