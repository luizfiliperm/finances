package com.wallet.finances.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wallet.finances.entities.user.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
    Boolean existsByEmail(String email);

    Boolean existsByUsername(String username);
    
}
