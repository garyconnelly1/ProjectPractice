package com.example.demo.service;

import com.example.demo.model.User;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class UserService {

    @PersistenceContext(name = "MyPU")
    EntityManager em;

    public User save(User user) {
        em.persist(user.getAddress());
        em.persist(user);
        return user;
    }

    public List<User> findAll() {
        return em.createNamedQuery("User.findAll", User.class).getResultList();
    }

    public User findById(int id) {
        try {
            return em.createQuery("select u from User u where u.userId = " + id, User.class).getSingleResult();
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    public User update(User user) {
        try {
            em.merge(user.getAddress());
            return em.merge(user);
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    public boolean delete(int id) {
        try {
            User user = findById(id);
            em.remove(user.getAddress());
            em.remove(user);
            return true;
        } catch(Exception  e) {
            System.err.println(e);
            return false;
        }
    }
}
