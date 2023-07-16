package com.wallet.finances.services;

import java.util.List;

import com.wallet.finances.entities.transactions.income.Income;

public interface IncomeService {

    Income addIncome(Income income, String username);

    List<Income> getAll(String username);

    void deleteIncomes(List<Long> ids);
}
