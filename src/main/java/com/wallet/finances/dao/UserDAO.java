package com.wallet.finances.dao;

import java.util.List;

import com.wallet.finances.entities.User;

public interface UserDAO {
    List<User> findAll();
    
    User findById(Long id);

    User save(User user);

    void deleteById(Long id);
}
