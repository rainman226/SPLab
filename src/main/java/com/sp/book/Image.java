package com.sp.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Image implements Element{
    private String imageName;
    public void print(){
        System.out.println("Image with name:" + this.imageName);
    }
}
