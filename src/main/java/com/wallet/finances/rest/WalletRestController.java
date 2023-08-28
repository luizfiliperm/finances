package com.wallet.finances.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wallet.finances.entities.wallet.Wallet;
import com.wallet.finances.entities.wallet.WalletWithIncomesResponseDTO;
import com.wallet.finances.services.WalletService;

@RestController
@RequestMapping("/wallet")
public class WalletRestController {

    @Autowired
    WalletService walletService;
    
    @GetMapping
    @RequestMapping("/incomes")
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
}
