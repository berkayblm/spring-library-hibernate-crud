package com.berka.springbootlibrarymanagement.dao;

import com.berka.springbootlibrarymanagement.entity.Book;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAOImplementation implements BookDAO {

    private EntityManager entityManager;

    @Autowired
    public BookDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Book> findAll() {
        Session session = createSession();

        Query<Book> query = session.createQuery(
                "from Book ", Book.class
        );

        List<Book> books = query.getResultList();

        return books;
    }

    @Override
    public Book findById(int theId) {
        Session session = createSession();

        Book book = session.get(Book.class, theId);

        return book;
    }

    @Override
    public void save(Book book) {
        Session session = createSession();

        session.saveOrUpdate(book);
    }

    @Override
    public void deleteById(int theId) {
        Session session = createSession();

        Query query =
                session.createQuery("delete from Book where id =: bookId");

        query.setParameter("bookId", theId);
        query.executeUpdate();
    }

    private Session createSession() {
        Session session = entityManager.unwrap(Session.class);

        return session;
    }


}
