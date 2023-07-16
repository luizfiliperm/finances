package com.wallet.finances.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wallet.finances.entities.transactions.income.IncomeRequestDTO;
import com.wallet.finances.entities.transactions.income.IncomeResponseDTO;
import com.wallet.finances.services.IncomeService;

@RestController
@RequestMapping("/transactions")
public class IncomeRestController {
    
    @Autowired
    private IncomeService incomeService;

    @PostMapping(path = "/incomes")
    public IncomeResponseDTO addIncome(IncomeRequestDTO data){
        
    }
}
