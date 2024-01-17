package com.sp.helpers;

public class AlignCenter implements AlignStrategy {
    @Override
    public void render(String text) {
        System.out.println("Paragraph: "  + "#" + text + "#");
    }
}
