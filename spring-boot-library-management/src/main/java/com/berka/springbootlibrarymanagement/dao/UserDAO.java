package com.berka.springbootlibrarymanagement.dao;

import com.berka.springbootlibrarymanagement.entity.Book;
import com.berka.springbootlibrarymanagement.entity.User;

import java.util.List;

public interface UserDAO {

    List<User> findAll();

    User findById(int theId);

    void save(User theUser);

    void deleteById(int theId);

    List<Book> findBooksByUserId(int id);

}
