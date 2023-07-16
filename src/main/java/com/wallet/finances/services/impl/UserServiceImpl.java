package com.wallet.finances.services.impl;

import java.util.List;
import java.util.Optional;

import com.wallet.finances.entities.wallet.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.wallet.finances.repositories.UserRepository;
import com.wallet.finances.entities.user.User;
import com.wallet.finances.exceptions.user.UserAlreadyExistsException;
import com.wallet.finances.exceptions.user.UserAuthenticationException;
import com.wallet.finances.exceptions.user.UserNotFoundException;
import com.wallet.finances.infra.security.TokenService;
import com.wallet.finances.services.UserService;
import com.wallet.finances.util.UserUtil;

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

        UserUtil.validateUserName(user.getUsername());
        UserUtil.validatePassword(user);

        user.setPassword(UserUtil.hashPassword(user.getPassword()));
        user.setWallet(createWallet(user));
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
        try {
            var usernamePassword = new UsernamePasswordAuthenticationToken(login, password);
            var auth = authenticationManager.authenticate(usernamePassword);
            return (User) auth.getPrincipal();
            
        } catch (BadCredentialsException | InternalAuthenticationServiceException exception) {
            throw new UserAuthenticationException("Bad credentials!");
        }
        

    }

    private String generateToken(User user){
        String token = tokenService.genToken(user);
        return token;
    }

    private Wallet createWallet(User user){
        Wallet wallet = new Wallet();
        wallet.setUser(user);
        return wallet;
    }

    
    
}
