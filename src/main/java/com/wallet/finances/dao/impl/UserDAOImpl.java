package com.wallet.finances.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wallet.finances.dao.UserDAO;
import com.wallet.finances.entities.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class UserDAOImpl implements UserDAO {

    EntityManager entityManager;

    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> findAll() {
        TypedQuery<User> query = entityManager.createQuery("SELECT FROM User", User.class);

        return query.getResultList();
    }

    @Override
    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User save(User user) {
        return entityManager.merge(user);
    }

    @Override
    public void deleteById(Long id) {

        entityManager.remove(findById(id));
    }
    
}
