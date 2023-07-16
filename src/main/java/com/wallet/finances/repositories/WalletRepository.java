package com.wallet.finances.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wallet.finances.entities.wallet.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Long> {

    Wallet findByUserUsername(String username);
    
}
