package com.wallet.finances.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wallet.finances.dao.UserDAO;
import com.wallet.finances.entities.User;
import com.wallet.finances.services.UserService;

import jakarta.transaction.Transactional;

@Service
public class UserSericeImpl implements UserService{

    private UserDAO userDAO;

    public UserSericeImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public User findById(Long id) {
        return userDAO.findById(id);
    }

    @Transactional
    @Override
    public User save(User user) {
        return userDAO.save(user);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        userDAO.deleteById(id);
    }
    
}
