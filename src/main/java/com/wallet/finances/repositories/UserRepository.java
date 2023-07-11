package com.wallet.finances.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wallet.finances.entities.user.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long>{
    
    Boolean existsByEmail(String email);

    Boolean existsByUsername(String username);

    UserDetails findByUsername(String username);

    UserDetails findByEmail(String email);

    
}
