package com.wallet.finances.services;

import com.wallet.finances.entities.transactions.Income;

import java.util.List;

public interface IncomeService {

    Income addIncome(Income income);

    List<Income> getAll();

    void deleteIncomes(List<Long> ids);
}
