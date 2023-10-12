package com.sp.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Table {
    private String title;

    public void print() {
        System.out.println("Table with Title: " + this.title);
    }
}
