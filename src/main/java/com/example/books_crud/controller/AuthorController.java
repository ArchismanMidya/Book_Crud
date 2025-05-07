package com.example.books_crud.controller;

import com.example.books_crud.model.Author;
import com.example.books_crud.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    // Display list of all authors
    @GetMapping
    public String listAuthors(Model model) {
        model.addAttribute("authors", authorService.getAllAuthors());
        return "listAuthors";
    }

    // Display form to add a new author
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("author", new Author());
        return "addAuthor";
    }

    // Process form submission to add a new author
    @PostMapping("/add")
    public String addAuthor(@ModelAttribute Author author, RedirectAttributes redirectAttributes) {
        try {
            authorService.createAuthor(author);
            redirectAttributes.addFlashAttribute("message", "Author added successfully!");
            return "redirect:/authors";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error adding author: " + e.getMessage());
            return "redirect:/authors/add";
        }
    }

    // Display form to update an existing author
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        Optional<Author> author = authorService.getAuthorById(id);
        if (author.isPresent()) {
            model.addAttribute("author", author.get());
            return "updateAuthor";
        } else {
            redirectAttributes.addFlashAttribute("error", "Author not found!");
            return "redirect:/authors";
        }
    }

    // Process form submission to update an existing author
    @PostMapping("/update")
    public String updateAuthor(@ModelAttribute Author author, RedirectAttributes redirectAttributes) {
        try {
            authorService.updateAuthor(author);
            redirectAttributes.addFlashAttribute("message", "Author updated successfully!");
            return "redirect:/authors";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error updating author: " + e.getMessage());
            return "redirect:/authors/update/" + author.getId();
        }
    }
}