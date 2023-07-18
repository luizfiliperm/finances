package com.wallet.finances.repositories;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wallet.finances.entities.wallet.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Long> {

    Wallet findByUserUsername(String username);

    @Modifying
    @Query("UPDATE Wallet w SET w.totalIncome = (SELECT COALESCE(SUM(i.value), 0) FROM Income i WHERE i.wallet.id = :walletId)")
    void updateTotalIncome(@Param("walletId") Long walletId);
    
    @Query("SELECT DISTINCT w FROM Wallet w JOIN FETCH w.transactions t WHERE w.id = :walletId AND t.date BETWEEN :startDate AND :endDate")
    Wallet findByIdAndDateRange(@Param("walletId") Long walletId, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
