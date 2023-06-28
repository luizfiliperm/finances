package com.wallet.finances.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wallet.finances.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
