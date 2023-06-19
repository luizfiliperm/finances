package com.wallet.finances.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wallet.finances.entities.User;
import com.wallet.finances.services.UserService;

@RestController
@RequestMapping("/api")
public class UserRestController {
    
    private UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> findAll() {

        return userService.findAll();
    }

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable Long userId) {
        User user = userService.findById(userId);

        if (user == null) {
            throw new RuntimeException("User id not found - " + userId);
        }

        return user;
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        user.setId(0L);

        return userService.save(user);
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable Long userId) {

        User user = userService.findById(userId);

        if (user == null) {
            throw new RuntimeException("User id not found - " + userId);
        }

        userService.deleteById(userId);
        
        return "Deleted user id - " + userId;
    }
}
