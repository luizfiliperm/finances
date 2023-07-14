package com.wallet.finances.entities.transactions;

import com.wallet.finances.entities.transactions.enums.IncomeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Income extends Transaction {
    @Column(name = "income_Type")
    private IncomeType incomeType;

    public Income() {
    }

    public Income(Long id, String name, BigDecimal value, Date date, IncomeType incomeType) {
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
