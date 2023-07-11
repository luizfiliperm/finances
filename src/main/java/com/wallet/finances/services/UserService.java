package com.wallet.finances.services;

import java.util.List;

import com.wallet.finances.entities.user.User;

public interface UserService {
    List<User> findAll();
    
    User findById(Long id);

    String authenticate(User user);

    void deleteById(Long id);
}
