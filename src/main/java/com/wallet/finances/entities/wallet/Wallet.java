package com.wallet.finances.entities.wallet;

import java.util.List;

import com.wallet.finances.entities.user.User;
import com.wallet.finances.entities.transactions.Transaction;

import jakarta.persistence.Entity;

@Entity
public class Wallet {
    
    private Long id;

    private User user;

    private List<Transaction> transactions;
}
