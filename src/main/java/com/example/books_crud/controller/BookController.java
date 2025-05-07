package com.example.books_crud.controller;

import com.example.books_crud.model.Book;
import com.example.books_crud.service.AuthorService;
import com.example.books_crud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;

    @Autowired
    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    // Display list of all books
    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "listBooks";
    }
    
    // Display list of all books with author information using custom query
    @GetMapping("/with-authors")
    public String listBooksWithAuthors(Model model) {
        List<Object[]> booksWithAuthors = bookService.getBooksWithAuthor();
        model.addAttribute("booksWithAuthors", booksWithAuthors);
        return "listBooksWithAuthors";
    }

    // Display form to add a new book
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("authors", authorService.getAllAuthors());
        return "addBook";
    }

    // Process form submission to add a new book
    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book, RedirectAttributes redirectAttributes) {
        try {
            bookService.createBook(book);
            redirectAttributes.addFlashAttribute("message", "Book added successfully!");
            return "redirect:/books";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error adding book: " + e.getMessage());
            return "redirect:/books/add";
        }
    }

    // Display form to update an existing book
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        Optional<Book> book = bookService.getBookById(id);
        if (book.isPresent()) {
            model.addAttribute("book", book.get());
            model.addAttribute("authors", authorService.getAllAuthors());
            return "updateBook";
        } else {
            redirectAttributes.addFlashAttribute("error", "Book not found!");
            return "redirect:/books";
        }
    }

    // Process form submission to update an existing book
    @PostMapping("/update")
    public String updateBook(@ModelAttribute Book book, RedirectAttributes redirectAttributes) {
        try {
            bookService.updateBook(book);
            redirectAttributes.addFlashAttribute("message", "Book updated successfully!");
            return "redirect:/books";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error updating book: " + e.getMessage());
            return "redirect:/books/update/" + book.getId();
        }
    }
}