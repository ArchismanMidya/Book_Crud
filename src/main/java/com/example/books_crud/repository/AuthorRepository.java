package com.example.books_crud.repository;

import com.example.books_crud.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    // Basic CRUD operations are provided by JpaRepository
}