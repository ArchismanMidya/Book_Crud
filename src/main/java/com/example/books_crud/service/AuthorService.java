package com.example.books_crud.service;

import com.example.books_crud.model.Author;
import com.example.books_crud.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    // Create a new author
    @Transactional
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    // Get all authors
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    // Get author by ID
    public Optional<Author> getAuthorById(Long id) {
        return authorRepository.findById(id);
    }

    // Update an existing author
    @Transactional
    public Author updateAuthor(Author author) {
        return authorRepository.save(author);
    }

    // Delete an author
    @Transactional
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}