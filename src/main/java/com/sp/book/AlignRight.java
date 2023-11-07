package com.sp.book;

public class AlignRight implements AlignStrategy {
    @Override
    public void render(String text) {
        System.out.println("Paragraph: " + "#" + text);
    }
}
