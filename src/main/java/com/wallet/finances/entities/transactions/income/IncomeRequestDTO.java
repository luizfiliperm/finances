package com.wallet.finances.entities.transactions.income;

import java.math.BigDecimal;

import com.wallet.finances.entities.transactions.income.enums.IncomeType;

public record IncomeRequestDTO(String name, BigDecimal value, String date, IncomeType incomeType) {
    
}
