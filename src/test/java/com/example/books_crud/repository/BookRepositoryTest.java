package com.example.books_crud.repository;

import com.example.books_crud.model.Author;
import com.example.books_crud.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BookRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BookRepository bookRepository;

    @Test
    void fetchBookWithAuthor() {
        // Create test data
        Author author = new Author();
        author.setName("Test Author");
        author.setBio("Test Bio");
        entityManager.persist(author);

        Book book = new Book();
        book.setTitle("Test Book");
        book.setIsbn("1234567890");
        book.setAuthor(author);
        entityManager.persist(book);

        entityManager.flush();

        // Execute the query
        List<Object[]> result = bookRepository.fetchBookWithAuthor();

        // Verify the result
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        
        Object[] bookWithAuthor = result.get(0);
        assertEquals("Test Book", bookWithAuthor[0]);
        assertEquals("1234567890", bookWithAuthor[1]);
        assertEquals("Test Author", bookWithAuthor[2]);
    }
}