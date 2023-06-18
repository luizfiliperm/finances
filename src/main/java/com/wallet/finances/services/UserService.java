package com.wallet.finances.services;

import java.util.List;

import com.wallet.finances.entities.User;

public interface UserService {
    List<User> findAll();
    
    User findById(Long id);

    User save(User user);

    void deleteById(Long id);
}
