package com.sp.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Author  implements Visitee {
    public String name;

    public void print(){
        System.out.println("Author name: " + this.name);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitAuthor(this);
    }
}
