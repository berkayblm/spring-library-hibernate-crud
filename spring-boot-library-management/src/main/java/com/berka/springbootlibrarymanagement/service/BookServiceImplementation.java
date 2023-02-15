package com.berka.springbootlibrarymanagement.service;

import com.berka.springbootlibrarymanagement.dao.BookDAO;

import com.berka.springbootlibrarymanagement.entity.Book;
import com.berka.springbootlibrarymanagement.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImplementation implements BookService {

    private BookDAO bookDAO;

    @Autowired
    public BookServiceImplementation(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    @Transactional
    public List<Book> findAll() {
        return bookDAO.findAll();
    }

    @Override
    @Transactional
    public Book findById(int theId) {
        return bookDAO.findById(theId);
    }

    @Override
    @Transactional
    public void save(Book theBook) {
        bookDAO.save(theBook);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        bookDAO.deleteById(theId);
    }
}
