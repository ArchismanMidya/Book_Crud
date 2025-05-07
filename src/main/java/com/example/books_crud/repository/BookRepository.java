package com.example.books_crud.repository;

import com.example.books_crud.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    
    // Custom query to perform INNER JOIN between Book and Author
    @Query("SELECT b.title, b.isbn, a.name FROM Book b JOIN b.author a")
    List<Object[]> fetchBookWithAuthor();
}