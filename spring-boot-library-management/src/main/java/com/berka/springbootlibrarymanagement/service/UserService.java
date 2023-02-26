package com.berka.springbootlibrarymanagement.service;

import com.berka.springbootlibrarymanagement.entity.Book;
import com.berka.springbootlibrarymanagement.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(int theId);

    void save(User theUser);

    void deleteById(int theId);

    List<Book> findBooksByUserId(int id);

    void deleteBookForUser(List<Book> books, int bookId);

}
