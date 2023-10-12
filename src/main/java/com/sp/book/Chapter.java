package com.sp.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Chapter {
    private String name;
    private List<SubChapter> subChapterList;

    public Chapter(String name) {
        this.name = name;
        this.subChapterList = new ArrayList<SubChapter>();
    }

    public int createSubChapter(String subChapterTitle) {
        SubChapter newSubChapter = new SubChapter(subChapterTitle);
        subChapterList.add(newSubChapter);
        return subChapterList.indexOf(newSubChapter);
    }

    public SubChapter getSubChapter(int index) {
        if (index >= 0 && index < subChapterList.size()) {
            return subChapterList.get(index);
        } else {
            // Handle the case where the index is out of bounds, for example, return null or throw an exception.
            // You can choose the appropriate error handling strategy for your application.
            return null;
        }
    }
    public void print(){
        System.out.println("Chapter: " + this.name);

        for(SubChapter sc:subChapterList){
            sc.print();
        }
    }

}
