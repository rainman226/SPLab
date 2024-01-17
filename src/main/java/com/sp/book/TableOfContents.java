package com.sp.book;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class TableOfContents extends Element implements Visitee {

    private List<String> entries;

    public TableOfContents(){
        entries = new ArrayList<>();
    }

    public TableOfContents(TableOfContents other){
        entries = new ArrayList<>(other.entries);
    }

    @Override
    public void print() {}

    @Override
    public Element clone() {
        return new TableOfContents(this);
    };

    @Override
    public void accept(Visitor visitor) {
        visitor.visitTableOfContents(this);
    }

    public void addEntry(String entry){
        entries.add(entry);
    }
}