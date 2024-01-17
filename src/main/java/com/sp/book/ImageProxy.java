package com.sp.book;

import lombok.Getter;

public class ImageProxy extends BaseElement implements Picture, Visitee {
    private Image realImage;
    private String url;

    public ImageProxy(String url){
        this.url = url;
    }

    @Override
    public String getUrl() {
        return url;
    }

    public Image loadImage(){
        if(realImage == null)
            realImage = new Image(url);
        return realImage;
    }



    @Override
    public BaseElement clone() {
        return null;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitImageProxy(this);
    }
}
