package com.sp.persistance;

import com.sp.book.Book;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface BooksRepository extends JpaRepository<Book, Integer> {
}