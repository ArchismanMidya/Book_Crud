package com.example.books_crud.service;

import com.example.books_crud.model.Author;
import com.example.books_crud.repository.AuthorRepository;
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

class AuthorServiceTest {

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private AuthorService authorService;

    private Author testAuthor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        
        testAuthor = new Author();
        testAuthor.setId(1L);
        testAuthor.setName("Test Author");
        testAuthor.setBio("Test Bio");
    }

    @Test
    void createAuthor() {
        when(authorRepository.save(any(Author.class))).thenReturn(testAuthor);
        
        Author createdAuthor = authorService.createAuthor(testAuthor);
        
        assertNotNull(createdAuthor);
        assertEquals(testAuthor.getId(), createdAuthor.getId());
        assertEquals(testAuthor.getName(), createdAuthor.getName());
        assertEquals(testAuthor.getBio(), createdAuthor.getBio());
        
        verify(authorRepository, times(1)).save(any(Author.class));
    }

    @Test
    void getAllAuthors() {
        List<Author> authors = Arrays.asList(testAuthor);
        when(authorRepository.findAll()).thenReturn(authors);
        
        List<Author> result = authorService.getAllAuthors();
        
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(testAuthor.getId(), result.get(0).getId());
        
        verify(authorRepository, times(1)).findAll();
    }

    @Test
    void getAuthorById() {
        when(authorRepository.findById(1L)).thenReturn(Optional.of(testAuthor));
        
        Optional<Author> result = authorService.getAuthorById(1L);
        
        assertTrue(result.isPresent());
        assertEquals(testAuthor.getId(), result.get().getId());
        
        verify(authorRepository, times(1)).findById(1L);
    }

    @Test
    void updateAuthor() {
        when(authorRepository.save(any(Author.class))).thenReturn(testAuthor);
        
        Author updatedAuthor = authorService.updateAuthor(testAuthor);
        
        assertNotNull(updatedAuthor);
        assertEquals(testAuthor.getId(), updatedAuthor.getId());
        
        verify(authorRepository, times(1)).save(any(Author.class));
    }

    @Test
    void deleteAuthor() {
        doNothing().when(authorRepository).deleteById(1L);
        
        authorService.deleteAuthor(1L);
        
        verify(authorRepository, times(1)).deleteById(1L);
    }
}