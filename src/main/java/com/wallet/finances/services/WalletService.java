package com.wallet.finances.services;

import com.wallet.finances.entities.wallet.Wallet;

public interface WalletService {
    
    Wallet getWalletWithTransactionsByDateRange(String username, String startDate, String endDate);

    Wallet getWalletWithTransactionsBeforeDate(String username, String date);

    Wallet getWalletWithTransactionsAfterDate(String username, String date);

    Wallet getWalletWithTransactions(String username);
}
