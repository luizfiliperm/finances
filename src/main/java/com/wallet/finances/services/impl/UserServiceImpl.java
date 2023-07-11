package com.wallet.finances.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.wallet.finances.repositories.UserRepository;
import com.wallet.finances.entities.user.User;
import com.wallet.finances.exceptions.password.InvalidPasswordException;
import com.wallet.finances.exceptions.user.UserAlreadyExistsException;
import com.wallet.finances.exceptions.user.UserNotFoundException;
import com.wallet.finances.infra.security.TokenService;
import com.wallet.finances.services.UserService;
import com.wallet.finances.services.util.PasswordUtil;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);

        if(!user.isPresent()){
            throw new UserNotFoundException("User with id: " + id + " not found");
        }

        return user.get();
    }

    @Override
    public String register(User user) {
        if(userRepository.existsByEmail(user.getEmail())){
            throw new UserAlreadyExistsException("Already exists a user with this email!");
        }

        if(userRepository.existsByUsername(user.getUsername())){
            throw new UserAlreadyExistsException("Already exists a user with this username!");
        }

        if(!PasswordUtil.validatePassword(user)){
            throw new InvalidPasswordException("Invalid Password");
        }

        user.setPassword(PasswordUtil.hashPassword(user.getPassword()));
        userRepository.save(user);
        
        return generateToken(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }


    @Override
    public String login(String login, String password) {
        return generateToken(authUser(login, password));
    }

    private User authUser(String login, String password){
        var usernamePassword = new UsernamePasswordAuthenticationToken(login, password);
        var auth = authenticationManager.authenticate(usernamePassword);

        return (User) auth.getPrincipal();
    }

    private String generateToken(User user){
        String token = tokenService.genToken(user);
        return token;
    }

    
    
}
