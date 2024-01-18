package com.sp.helpers;

import com.sp.book.Book;

import java.io.IOException;

public interface Observer {
    void update(Book book) throws IOException;
}