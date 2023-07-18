package com.wallet.finances.services;

import com.wallet.finances.entities.wallet.Wallet;

public interface WalletService {
    
    Wallet getWalletWithTransactionsByDateRange(String username, String startDate, String endDate);
}
