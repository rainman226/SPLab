package com.sp.book;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sp.helpers.ElementDeserializer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@JsonDeserialize(using = ElementDeserializer.class)
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BaseElement implements Visitee {
    @Id
    @GeneratedValue
    protected Long id;

    public BaseElement() {}

    public void add(BaseElement e) {}
    public void remove(BaseElement e) {}
    public BaseElement get(int index) { throw new UnsupportedOperationException("not implemented for BaseElement");}
    public BaseElement clone(){
        throw new UnsupportedOperationException("not implemented for BaseElement");
    }
}