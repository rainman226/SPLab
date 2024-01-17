package com.sp.book;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Entity
@jakarta.persistence.Table(name = "ContentTable")
public class Table extends BaseElement implements Visitee {

    @Getter
    private String title;

    public Table() {
        title = "";
    }

    public Table(String title) {
        this.title = title;
    }
    public Table(Table other){
        this.title = other.title;
    }


    @Override
    public BaseElement clone() {
        return new Table(this);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitTable(this);
    }
}