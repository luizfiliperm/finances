package com.wallet.finances.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.wallet.finances.dao.UserRepository;
import com.wallet.finances.entities.User;
import com.wallet.finances.exceptions.user.UserAlreadyExistsException;
import com.wallet.finances.exceptions.user.UserNotFoundException;
import com.wallet.finances.services.UserService;


@Service
public class UserSericeImpl implements UserService{

    private UserRepository userRepository;

    public UserSericeImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

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
    public User save(User user) {
        boolean isCreating = user.getId() == 0L;

        if(isCreating){
            if(userRepository.existsByEmail(user.getEmail())){
                throw new UserAlreadyExistsException("Already exists a user with this email!");
            }

            if(userRepository.existsByUsername(user.getUsername())){
                throw new UserAlreadyExistsException("Already exists a user with this username!");
            }
        }

        return userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
    
}
