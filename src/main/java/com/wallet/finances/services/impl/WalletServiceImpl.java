package com.wallet.finances.services.impl;

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

        List<Income> incomes = incomeRepository.findAllByWalletIdAndDateBetween(wallet.getId(),DateTimeUtil.convertStringToLocalDate(startDate), DateTimeUtil.convertStringToLocalDate(endDate));

        wallet.setIncomes(incomes);

        wallet.calculateTotalIncome();

        return wallet;
    }

    @Override
    public Wallet getWalletWithTransactionsBeforeDate(String username, String date) {

        Wallet wallet = walletRepository.findByUserUsername(username);

        List<Income> incomes = incomeRepository.findAllByWalletIdAndDateBefore(wallet.getId(),DateTimeUtil.convertStringToLocalDate(date));

        wallet.setIncomes(incomes);

        wallet.calculateTotalIncome();

        return wallet;
    }

    @Override
    public Wallet getWalletWithTransactionsAfterDate(String username, String date) {
            
            Wallet wallet = walletRepository.findByUserUsername(username);
    
            List<Income> incomes = incomeRepository.findAllByWalletIdAndDateAfter(wallet.getId(),DateTimeUtil.convertStringToLocalDate(date));
    
            wallet.setIncomes(incomes);
    
            wallet.calculateTotalIncome();
    
            return wallet;
    }

    @Override
    public Wallet getWalletWithTransactions(String username) {

        Wallet wallet = walletRepository.findByUserUsername(username);

        List<Income> incomes = incomeRepository.findAllByWalletId(wallet.getId());

        wallet.setIncomes(incomes);

        wallet.calculateTotalIncome();

        return wallet;
    }
    
}
