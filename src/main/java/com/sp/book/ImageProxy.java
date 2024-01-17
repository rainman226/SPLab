package com.sp.book;

import lombok.Getter;

@Getter
public class ImageProxy extends Element  implements Picture, Visitee{
    private Image realImage;
    private String url;

    public ImageProxy(String url) {
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
    public void print() {
        loadImage().print();
    }

    @Override
    public Element clone() {
        return null;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitImageProxy(this);
    }
}
