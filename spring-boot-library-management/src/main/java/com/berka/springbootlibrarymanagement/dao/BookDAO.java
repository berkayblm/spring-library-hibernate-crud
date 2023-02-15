package com.berka.springbootlibrarymanagement.dao;

import com.berka.springbootlibrarymanagement.entity.Book;

import java.util.List;

public interface BookDAO {
    List<Book> findAll();

    Book findById(int theId);

    void save(Book book);

    void deleteById(int theId);
}
