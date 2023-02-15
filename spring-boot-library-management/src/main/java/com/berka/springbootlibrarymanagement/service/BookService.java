package com.berka.springbootlibrarymanagement.service;

import com.berka.springbootlibrarymanagement.entity.Book;


import java.util.List;

public interface BookService {

    List<Book> findAll();

    Book findById(int theId);

    void save(Book theUser);

    void deleteById(int theId);
}
