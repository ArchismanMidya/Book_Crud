package com.example.books_crud.repository;

import com.example.books_crud.model.Author;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AuthorRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    void findById() {
        // Create test data
        Author author = new Author();
        author.setName("Test Author");
        author.setBio("Test Bio");
        entityManager.persist(author);
        entityManager.flush();

        // Execute the query
        Optional<Author> result = authorRepository.findById(author.getId());

        // Verify the result
        assertTrue(result.isPresent());
        assertEquals("Test Author", result.get().getName());
        assertEquals("Test Bio", result.get().getBio());
    }

    @Test
    void findAll() {
        // Create test data
        Author author1 = new Author();
        author1.setName("Test Author 1");
        author1.setBio("Test Bio 1");
        entityManager.persist(author1);

        Author author2 = new Author();
        author2.setName("Test Author 2");
        author2.setBio("Test Bio 2");
        entityManager.persist(author2);

        entityManager.flush();

        // Execute the query
        List<Author> result = authorRepository.findAll();

        // Verify the result
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    void save() {
        // Create test data
        Author author = new Author();
        author.setName("Test Author");
        author.setBio("Test Bio");

        // Execute the save
        Author savedAuthor = authorRepository.save(author);

        // Verify the result
        assertNotNull(savedAuthor.getId());
        assertEquals("Test Author", savedAuthor.getName());
        assertEquals("Test Bio", savedAuthor.getBio());

        // Verify it's in the database
        Author foundAuthor = entityManager.find(Author.class, savedAuthor.getId());
        assertNotNull(foundAuthor);
        assertEquals("Test Author", foundAuthor.getName());
    }

    @Test
    void delete() {
        // Create test data
        Author author = new Author();
        author.setName("Test Author");
        author.setBio("Test Bio");
        entityManager.persist(author);
        entityManager.flush();

        // Execute the delete
        authorRepository.deleteById(author.getId());

        // Verify it's deleted
        Author foundAuthor = entityManager.find(Author.class, author.getId());
        assertNull(foundAuthor);
    }
}