package com.wallet.finances.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.wallet.finances.entities.transactions.expense.Expense;


public interface ExpenseRepository extends JpaRepository<Expense, Long> {


    List<Expense> getAllByWalletId(Long walletId);

    void deleteByIdAndWalletId(Long id, Long walletId);

}
