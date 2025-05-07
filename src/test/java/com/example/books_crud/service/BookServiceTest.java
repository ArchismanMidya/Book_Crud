package com.example.books_crud.service;

import com.example.books_crud.model.Author;
import com.example.books_crud.model.Book;
import com.example.books_crud.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    private Book testBook;
    private Author testAuthor;
    private List<Object[]> booksWithAuthors;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        testAuthor = new Author();
        testAuthor.setId(1L);
        testAuthor.setName("Test Author");
        testAuthor.setBio("Test Bio");

        testBook = new Book();
        testBook.setId(1L);
        testBook.setTitle("Test Book");
        testBook.setIsbn("1234567890");
        testBook.setAuthor(testAuthor);

        // Mock data for the custom query
        booksWithAuthors = new java.util.ArrayList<>();
        booksWithAuthors.add(new Object[]{"Test Book", "1234567890", "Test Author"});
    }

    @Test
    void createBook() {
        when(bookRepository.save(any(Book.class))).thenReturn(testBook);

        Book createdBook = bookService.createBook(testBook);

        assertNotNull(createdBook);
        assertEquals(testBook.getId(), createdBook.getId());
        assertEquals(testBook.getTitle(), createdBook.getTitle());
        assertEquals(testBook.getIsbn(), createdBook.getIsbn());
        assertEquals(testBook.getAuthor().getId(), createdBook.getAuthor().getId());

        verify(bookRepository, times(1)).save(any(Book.class));
    }

    @Test
    void getAllBooks() {
        List<Book> books = Arrays.asList(testBook);
        when(bookRepository.findAll()).thenReturn(books);

        List<Book> result = bookService.getAllBooks();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(testBook.getId(), result.get(0).getId());

        verify(bookRepository, times(1)).findAll();
    }

    @Test
    void getBookById() {
        when(bookRepository.findById(1L)).thenReturn(Optional.of(testBook));

        Optional<Book> result = bookService.getBookById(1L);

        assertTrue(result.isPresent());
        assertEquals(testBook.getId(), result.get().getId());

        verify(bookRepository, times(1)).findById(1L);
    }

    @Test
    void updateBook() {
        when(bookRepository.save(any(Book.class))).thenReturn(testBook);

        Book updatedBook = bookService.updateBook(testBook);

        assertNotNull(updatedBook);
        assertEquals(testBook.getId(), updatedBook.getId());

        verify(bookRepository, times(1)).save(any(Book.class));
    }

    @Test
    void deleteBook() {
        doNothing().when(bookRepository).deleteById(1L);

        bookService.deleteBook(1L);

        verify(bookRepository, times(1)).deleteById(1L);
    }

    @Test
    void getBooksWithAuthor() {
        when(bookRepository.fetchBookWithAuthor()).thenReturn(booksWithAuthors);

        List<Object[]> result = bookService.getBooksWithAuthor();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Test Book", result.get(0)[0]);
        assertEquals("1234567890", result.get(0)[1]);
        assertEquals("Test Author", result.get(0)[2]);

        verify(bookRepository, times(1)).fetchBookWithAuthor();
    }
}
