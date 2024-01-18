package com.sp.helpers;

import com.sp.book.Book;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class AllBooksSubject {
    private final List<Observer> observerCollection;

    public AllBooksSubject() {
        this.observerCollection = new ArrayList<>();
    }

    public void attach(Observer observer) {
        observerCollection.add(observer);
    }

    public void detach(Observer observer) {
        observerCollection.remove(observer);
    }

    public void notifyObservers(Book book) {
        for (int i = observerCollection.size() - 1; i >= 0; i--) {
            try {
                observerCollection.get(i).update(book);
            } catch (IOException e) {
                detach(observerCollection.get(i));
            }
        }
    }

    public void add(Book book) {
        notifyObservers(book);
    }
}