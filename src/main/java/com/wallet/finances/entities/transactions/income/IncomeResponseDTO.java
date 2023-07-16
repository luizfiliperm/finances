package com.wallet.finances.entities.transactions.income;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.wallet.finances.entities.transactions.income.enums.IncomeType;

public record IncomeResponseDTO(Long id, String name, BigDecimal value, LocalDate date, IncomeType incomeType) {

    public IncomeResponseDTO(Income income){
        this(income.getId(), income.getName(), income.getValue(), income.getDate(), income.getIncomeType());
    }
}
