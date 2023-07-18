package com.wallet.finances.repositories;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wallet.finances.entities.wallet.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Long> {

    Wallet findByUserUsername(String username);
    
    @Query("SELECT DISTINCT w FROM Wallet w JOIN FETCH w.transactions t WHERE w.id = :walletId AND t.date BETWEEN :startDate AND :endDate")
    Wallet findByIdAndDateRange(@Param("walletId") Long walletId, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
