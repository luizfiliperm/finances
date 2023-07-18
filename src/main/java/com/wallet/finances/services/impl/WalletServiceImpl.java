package com.wallet.finances.services.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wallet.finances.entities.transactions.income.Income;
import com.wallet.finances.entities.wallet.Wallet;
import com.wallet.finances.repositories.IncomeRepository;
import com.wallet.finances.repositories.WalletRepository;
import com.wallet.finances.services.WalletService;
import com.wallet.finances.util.DateTimeUtil;


@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    WalletRepository walletRepository;

    @Autowired
    IncomeRepository incomeRepository;

    @Override
    public Wallet getWalletWithTransactionsByDateRange(String username, String startDate, String endDate) {

        Wallet wallet = walletRepository.findByUserUsername(username);

        LocalDate startLocalDate = LocalDate.parse(startDate, DateTimeUtil.FORMATTER);

        LocalDate endLocalDate = LocalDate.parse(startDate, DateTimeUtil.FORMATTER);

        // List<Income> incomes = incomeRepository.getAllByDateInterval(startLocalDate, endLocalDate);

        // wallet.setIncomes(incomes);

        return wallet;


    }
    
}
