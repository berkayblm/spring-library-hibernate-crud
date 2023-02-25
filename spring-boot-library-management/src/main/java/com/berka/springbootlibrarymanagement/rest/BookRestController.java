package com.berka.springbootlibrarymanagement.rest;

import com.berka.springbootlibrarymanagement.entity.Book;
import com.berka.springbootlibrarymanagement.entity.User;
import com.berka.springbootlibrarymanagement.service.BookService;
import com.berka.springbootlibrarymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookRestController {

    private BookService bookService;
    private UserService userService;

    @Autowired
    public BookRestController(BookService bookService, UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
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

    // add book to the Book table

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {

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

    // todo : add book for a given user id
    @PostMapping("/books/{userId}/{bookId}")
    public ResponseEntity<User> addBookForUser(
            @PathVariable int userId,
            @PathVariable int bookId) {

        User tempUser = userService.findById(userId);

        if (tempUser == null) {

            throw new RuntimeException("User id : "+ userId + " not found");
        }

        Book tempBook = bookService.findById(bookId);
        if (tempBook == null) {

            throw new RuntimeException("Book id : "+ bookId + " not found");

        }

        tempUser.addBook(tempBook); // add book for the given user

        userService.save(tempUser); // save the user with added book

        return new ResponseEntity<>(tempUser,HttpStatus.OK); // return response


    }





}
