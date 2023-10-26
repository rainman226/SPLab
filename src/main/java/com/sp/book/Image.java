package com.sp.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.TimeUnit;

public class Image extends Element implements Picture{
    private String url;
    private String imageContent;

    public Image(String url) {
        this.url = url;
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Image(Image other) {
        this.url = other.url;
    }
    @Override
    public void print(){
        System.out.println("Image with name:" + this.url);
    }

    @Override
    public Element clone() {
        return new Image(this);
    }

    @Override
    public String getUrl() {
        return url;
    }
}
