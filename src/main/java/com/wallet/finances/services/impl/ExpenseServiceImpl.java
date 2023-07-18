package com.wallet.finances.services.impl;

import com.wallet.finances.entities.transactions.expense.Expense;
import com.wallet.finances.entities.wallet.Wallet;
import com.wallet.finances.repositories.ExpenseRepository;
import com.wallet.finances.repositories.WalletRepository;
import com.wallet.finances.services.ExpenseService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    WalletRepository walletRepository;
    @Autowired
    ExpenseRepository expenseRepository;

    @Override
    public Expense addExpense(Expense expense, String username){
        Wallet wallet = walletRepository.findByUserUsername(username);

        expense.setWallet(wallet);

        return expenseRepository.save(expense);
    }

    @Override
    public List<Expense> getAll(String username){
        Wallet wallet = walletRepository.findByUserUsername(username);

        return expenseRepository.getAllByWalletId(wallet.getId());
    }

    @Override
    @Transactional
    public void deleteExpenses(List<Long> ids, String username){
        Wallet wallet = walletRepository.findByUserUsername(username);



    }


}

