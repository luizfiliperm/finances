package com.wallet.finances.services;

import com.wallet.finances.entities.transactions.expense.Expense;
import jakarta.transaction.Transactional;

import java.util.List;

public interface ExpenseService {

    Expense addExpense(Expense expense, String username);

    List<Expense> getAll(String username);

    void deleteExpenses(List<Long> ids, String username);
}
