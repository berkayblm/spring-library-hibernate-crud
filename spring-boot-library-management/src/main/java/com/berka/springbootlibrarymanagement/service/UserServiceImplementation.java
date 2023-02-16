package com.berka.springbootlibrarymanagement.service;

import com.berka.springbootlibrarymanagement.dao.UserDAO;
import com.berka.springbootlibrarymanagement.entity.Book;
import com.berka.springbootlibrarymanagement.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {

    private UserDAO userDAO;

    @Autowired
    public UserServiceImplementation(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    @Override
    @Transactional
    public List<User> findAll() {
        return  userDAO.findAll();
    }

    @Override
    @Transactional
    public User findById(int theId) {
        return userDAO.findById(theId);
    }

    @Override
    @Transactional
    public void save(User theUser) {
        userDAO.save(theUser);

    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        userDAO.deleteById(theId);
    }

    @Override
    @Transactional
    public List<Book> findBooksByUserId(int id) {
        return userDAO.findBooksByUserId(id);
    }
}
