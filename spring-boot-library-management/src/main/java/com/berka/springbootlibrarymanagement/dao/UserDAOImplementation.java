package com.berka.springbootlibrarymanagement.dao;


import com.berka.springbootlibrarymanagement.entity.User;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImplementation implements UserDAO {

    private EntityManager entityManager;

    @Autowired
    public UserDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<User> findAll() {

        Session session = createSession();

        Query<User> query = session.createQuery(
                "from User ", User.class
        );

        List<User> users = query.getResultList();

        return users;

    }

    @Override
    public User findById(int theId) {
        Session session = createSession();

        User user = session.get(User.class, theId);

        return user;

    }

    @Override
    public void save(User theUser) {

        Session session = createSession();

        session.saveOrUpdate(theUser);

    }

    @Override
    public void deleteById(int theId) {
        Session session = createSession();

        Query query =
                session.createQuery("delete from User where id =: userId");

        query.setParameter("userId", theId);
        query.executeUpdate();
    }

    private Session createSession() {
        Session session = entityManager.unwrap(Session.class);

        return session;
    }
}
