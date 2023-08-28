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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wallet.finances.entities.transactions.income.Income;
import com.wallet.finances.entities.transactions.income.IncomeRequestDTO;
import com.wallet.finances.entities.transactions.income.IncomeResponseDTO;
import com.wallet.finances.entities.wallet.Wallet;
import com.wallet.finances.entities.wallet.WalletWithIncomesResponseDTO;
import com.wallet.finances.services.IncomeService;
import com.wallet.finances.services.WalletService;

@RestController
@RequestMapping("/wallet")
public class IncomeRestController {
    
    @Autowired
    private IncomeService incomeService;

    @Autowired
    private WalletService walletService;

    @PostMapping(path = "/incomes")
    public IncomeResponseDTO addIncome(@RequestBody IncomeRequestDTO data, Authentication authentication){
        Income income = new Income(null, data.name(), data.value(), data.date(), data.incomeType());
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        incomeService.addIncome(income, userDetails.getUsername());

        return new IncomeResponseDTO(income);
    }

    @GetMapping(path = "/incomes")
    public WalletWithIncomesResponseDTO getWalletWithIncomes(
        @RequestParam(value = "startDate", required = false) String startDate, 
        @RequestParam(value = "endDate", required = false) String endDate, 
        Authentication authentication){

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        

        if(startDate == null && endDate == null){
            Wallet wallet = walletService.getWalletWithIncomes(userDetails.getUsername());
            return new WalletWithIncomesResponseDTO(wallet);
        }

        if(startDate == null){
            Wallet wallet = walletService.getWalletWithIncomesBeforeDate(userDetails.getUsername(), endDate);
            return new WalletWithIncomesResponseDTO(wallet);
        }

        if(endDate == null){
            Wallet wallet = walletService.getWalletWithIncomesAfterDate(userDetails.getUsername(), startDate);
            return new WalletWithIncomesResponseDTO(wallet);
        }

        Wallet wallet = walletService.getWalletWithIncomesByDateRange(userDetails.getUsername(), startDate, endDate);
        
        return new WalletWithIncomesResponseDTO(wallet);
    }

    @DeleteMapping(path = "/incomes")
    public String deleteIncomes(@RequestBody List<Long> ids, Authentication authentication){
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();


        incomeService.deleteIncomes(ids, userDetails.getUsername());

        return "Incomes deleted successfully";
    }
}
