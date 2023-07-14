package com.wallet.finances.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wallet.finances.entities.user.User;
import com.wallet.finances.services.UserService;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @Autowired
    private UserService userService;


    @GetMapping("/users")
    public List<User> findAll() {

        return userService.findAll();
    }

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable Long userId) {
        User user = userService.findById(userId);

        return user;
    }
}
