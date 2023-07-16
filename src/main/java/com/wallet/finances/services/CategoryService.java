package com.wallet.finances.services;

import java.util.List;

import com.wallet.finances.entities.transactions.expense.ExpenseCategory;

public interface CategoryService {
    List<ExpenseCategory> findAll();
    
    ExpenseCategory findById(Long id);

    ExpenseCategory save(ExpenseCategory expenseCategory);

    void deleteById(Long id);
}
