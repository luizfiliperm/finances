package com.wallet.finances.services;

import com.wallet.finances.entities.wallet.Wallet;

public interface WalletService {
    
    Wallet getWalletWithIncomesByDateRange(String username, String startDate, String endDate);

    Wallet getWalletWithIncomesBeforeDate(String username, String date);

    Wallet getWalletWithIncomesAfterDate(String username, String date);

    Wallet getWalletWithIncomes(String username);
}
