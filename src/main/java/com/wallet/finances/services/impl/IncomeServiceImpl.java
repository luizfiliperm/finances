package com.wallet.finances.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wallet.finances.entities.transactions.income.Income;
import com.wallet.finances.entities.wallet.Wallet;
import com.wallet.finances.repositories.IncomeRepository;
import com.wallet.finances.repositories.WalletRepository;
import com.wallet.finances.services.IncomeService;

@Service
public class IncomeServiceImpl implements IncomeService {

    @Autowired
    WalletRepository walletRepository;

    @Autowired
    IncomeRepository incomeRepository;

    @Override
    public Income addIncome(Income income, String username) {
        Wallet wallet = walletRepository.findByUserUsername(username);

        income.setWallet(wallet);
        
        return incomeRepository.save(income);
        
    }

    @Override
    public List<Income> getAll(String username) {
        Wallet wallet = walletRepository.findByUserUsername(username);

        return incomeRepository.getAllByWalletId(wallet.getId());
    }

    @Override
    public void deleteIncomes(List<Long> ids) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteIncomes'");
    }
    
}
