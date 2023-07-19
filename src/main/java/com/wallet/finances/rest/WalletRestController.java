package com.wallet.finances.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wallet.finances.entities.wallet.Wallet;
import com.wallet.finances.entities.wallet.WalletResponseDTO;
import com.wallet.finances.services.WalletService;

@RestController
@RequestMapping("/wallet")
public class WalletRestController {

    @Autowired
    WalletService walletService;
    
    @GetMapping
    public WalletResponseDTO getWallet(
        @RequestParam(value = "startDate", required = false) String startDate, 
        @RequestParam(value = "endDate", required = false) String endDate, 
        Authentication authentication){

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        

        if(startDate == null && endDate == null){
            Wallet wallet = walletService.getWalletWithTransactions(userDetails.getUsername());
            return new WalletResponseDTO(wallet);
        }

        if(startDate == null){
            Wallet wallet = walletService.getWalletWithTransactionsBeforeDate(userDetails.getUsername(), endDate);
            return new WalletResponseDTO(wallet);
        }

        if(endDate == null){
            Wallet wallet = walletService.getWalletWithTransactionsAfterDate(userDetails.getUsername(), startDate);
            return new WalletResponseDTO(wallet);
        }

        Wallet wallet = walletService.getWalletWithTransactionsByDateRange(userDetails.getUsername(), startDate, endDate);
        
        return new WalletResponseDTO(wallet);
    }
}
