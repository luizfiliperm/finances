package com.wallet.finances.entities.wallet;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.wallet.finances.entities.transactions.income.IncomeResponseDTO;

public record WalletResponseDTO(BigDecimal totalIncome, BigDecimal totalExpense, List<IncomeResponseDTO> incomes) {
    public WalletResponseDTO(Wallet wallet){
        this(wallet.getTotalIncome(), wallet.getTotalExpense(), getIncomeResponseDTOs(wallet));
    }

    private static List<IncomeResponseDTO> getIncomeResponseDTOs(Wallet wallet) {
    return wallet.getIncomes().stream()
                 .map(income -> new IncomeResponseDTO(income))
                 .collect(Collectors.toList());
    }
}
