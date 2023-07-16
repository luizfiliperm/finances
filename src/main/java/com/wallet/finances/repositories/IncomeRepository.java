package com.wallet.finances.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wallet.finances.entities.transactions.income.Income;

public interface IncomeRepository extends JpaRepository<Income, Long>{
    
    List<Income> getAllByWalletId(Long walletId);
}
