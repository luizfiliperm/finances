package com.wallet.finances.entities.transactions.income;

import com.wallet.finances.entities.transactions.Transaction;
import com.wallet.finances.entities.transactions.income.enums.IncomeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
public class Income extends Transaction {
    @Column(name = "income_Type")
    private IncomeType incomeType;

    public Income() {
    }

    public Income(Long id, String name, BigDecimal value, String date, IncomeType incomeType) {
        super(id, name, value, date);
        this.incomeType = incomeType;
    }

    public IncomeType getIncomeType() {
        return incomeType;
    }

    public void setIncomeType(IncomeType incomeType) {
        this.incomeType = incomeType;
    }
}
