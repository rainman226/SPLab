package com.sp.persistance;

import com.sp.book.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorsRepository extends JpaRepository<Author, Integer> {
}