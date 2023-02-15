package com.berka.springbootlibrarymanagement.rest;

import com.berka.springbootlibrarymanagement.entity.Book;
import com.berka.springbootlibrarymanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookRestController {

    private BookService bookService;

    @Autowired
    public BookRestController(BookService bookService) {

        this.bookService = bookService;
    }

    // get  /users
    @GetMapping("/books")
    public List<Book> findAll() {

        return bookService.findAll();
    }

    @GetMapping("/books/{bookId}")
    public Book getBook(@PathVariable int bookId) {

        Book book = bookService.findById(bookId);

        if (book == null) {
            throw new RuntimeException("Book id not found " + bookId);

        }

        return book;

    }

    @PostMapping("/books")
    public Book addUser(@RequestBody Book book) {

        book.setId(0);

        bookService.save(book);

        return book;

    }

    @PutMapping("/books")
    public Book updateBook(@RequestBody Book book) {

        bookService.save(book);
        return book;

    }

    @DeleteMapping("/books/{bookId}")
    public String deleteBook(@PathVariable int bookId) {
        Book book = bookService.findById(bookId);

        if (book == null) {
            throw new RuntimeException("Book id not found " + bookId);
        }

        bookService.deleteById(bookId);

        return "Deleted book id + " + bookId;
    }

    // todo : get all user for a given book, by book id



}
