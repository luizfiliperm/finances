package com.wallet.finances.services;

import com.wallet.finances.entities.transactions.expense.Expense;

import java.util.List;

public interface ExpenseService {

    Expense addExpense(Expense expense);

    List<Expense> getAll();

    void deleteExpenses(List<Long> ids);

}
