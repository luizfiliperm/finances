package com.wallet.finances.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wallet.finances.entities.transactions.income.Income;
import com.wallet.finances.entities.transactions.income.IncomeRequestDTO;
import com.wallet.finances.entities.transactions.income.IncomeResponseDTO;
import com.wallet.finances.services.IncomeService;

@RestController
@RequestMapping("/transactions")
public class IncomeRestController {
    
    @Autowired
    private IncomeService incomeService;

    @PostMapping(path = "/incomes")
    public IncomeResponseDTO addIncome(@RequestBody IncomeRequestDTO data, Authentication authentication){
        Income income = new Income(null, data.name(), data.value(), data.date(), data.incomeType());
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        incomeService.addIncome(income, userDetails.getUsername());

        return new IncomeResponseDTO(income);
    }

    @GetMapping(path = "/incomes")
    public List<IncomeResponseDTO> getAllIncomes(Authentication authentication){
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        return incomeService.getAll(userDetails.getUsername()).stream().map(IncomeResponseDTO::new).toList();

    }

    @DeleteMapping(path = "/incomes")
    public String deleteIncomes(@RequestBody List<Long> ids, Authentication authentication){
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();


        incomeService.deleteIncomes(ids, userDetails.getUsername());

        return "Incomes deleted successfully";
    }
}
