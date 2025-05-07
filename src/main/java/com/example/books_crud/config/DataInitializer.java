package com.example.books_crud.config;

import com.example.books_crud.model.Author;
import com.example.books_crud.model.Book;
import com.example.books_crud.service.AuthorService;
import com.example.books_crud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final AuthorService authorService;
    private final BookService bookService;

    @Autowired
    public DataInitializer(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        // Create 10 sample authors
        Author author1 = new Author();
        author1.setName("J.K. Rowling");
        author1.setBio("British author best known for the Harry Potter series.");
        authorService.createAuthor(author1);

        Author author2 = new Author();
        author2.setName("George Orwell");
        author2.setBio("English novelist, essayist, journalist, and critic.");
        authorService.createAuthor(author2);

        Author author3 = new Author();
        author3.setName("Jane Austen");
        author3.setBio("English novelist known for her six major novels.");
        authorService.createAuthor(author3);

        Author author4 = new Author();
        author4.setName("Ernest Hemingway");
        author4.setBio("American novelist, short-story writer, and journalist.");
        authorService.createAuthor(author4);

        Author author5 = new Author();
        author5.setName("Agatha Christie");
        author5.setBio("English writer known for her detective novels.");
        authorService.createAuthor(author5);

        Author author6 = new Author();
        author6.setName("F. Scott Fitzgerald");
        author6.setBio("American novelist, essayist, and short story writer.");
        authorService.createAuthor(author6);

        Author author7 = new Author();
        author7.setName("Mark Twain");
        author7.setBio("American writer, humorist, entrepreneur, publisher, and lecturer.");
        authorService.createAuthor(author7);

        Author author8 = new Author();
        author8.setName("Charles Dickens");
        author8.setBio("English writer and social critic.");
        authorService.createAuthor(author8);

        Author author9 = new Author();
        author9.setName("Leo Tolstoy");
        author9.setBio("Russian writer who is regarded as one of the greatest authors of all time.");
        authorService.createAuthor(author9);

        Author author10 = new Author();
        author10.setName("Stephen King");
        author10.setBio("American author of horror, supernatural fiction, suspense, crime, science-fiction, and fantasy novels.");
        authorService.createAuthor(author10);

        // Create 10 sample books
        Book book1 = new Book();
        book1.setTitle("Harry Potter and the Philosopher's Stone");
        book1.setIsbn("9780747532743");
        book1.setAuthor(author1);
        bookService.createBook(book1);

        Book book2 = new Book();
        book2.setTitle("1984");
        book2.setIsbn("9780451524935");
        book2.setAuthor(author2);
        bookService.createBook(book2);

        Book book3 = new Book();
        book3.setTitle("Pride and Prejudice");
        book3.setIsbn("9780141439518");
        book3.setAuthor(author3);
        bookService.createBook(book3);

        Book book4 = new Book();
        book4.setTitle("The Old Man and the Sea");
        book4.setIsbn("9780684801223");
        book4.setAuthor(author4);
        bookService.createBook(book4);

        Book book5 = new Book();
        book5.setTitle("Murder on the Orient Express");
        book5.setIsbn("9780062693662");
        book5.setAuthor(author5);
        bookService.createBook(book5);

        Book book6 = new Book();
        book6.setTitle("The Great Gatsby");
        book6.setIsbn("9780743273565");
        book6.setAuthor(author6);
        bookService.createBook(book6);

        Book book7 = new Book();
        book7.setTitle("The Adventures of Tom Sawyer");
        book7.setIsbn("9780143039563");
        book7.setAuthor(author7);
        bookService.createBook(book7);

        Book book8 = new Book();
        book8.setTitle("A Tale of Two Cities");
        book8.setIsbn("9780141439600");
        book8.setAuthor(author8);
        bookService.createBook(book8);

        Book book9 = new Book();
        book9.setTitle("War and Peace");
        book9.setIsbn("9781400079988");
        book9.setAuthor(author9);
        bookService.createBook(book9);

        Book book10 = new Book();
        book10.setTitle("The Shining");
        book10.setIsbn("9780307743657");
        book10.setAuthor(author10);
        bookService.createBook(book10);
    }
}