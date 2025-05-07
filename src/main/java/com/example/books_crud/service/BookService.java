package com.example.books_crud.service;

import com.example.books_crud.model.Book;
import com.example.books_crud.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Create a new book
    @Transactional
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    // Get all books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Get book by ID
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    // Update an existing book
    @Transactional
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    // Delete a book
    @Transactional
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
    
    // Get books with author information using custom query
    public List<Object[]> getBooksWithAuthor() {
        return bookRepository.fetchBookWithAuthor();
    }
}