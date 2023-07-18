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
        @RequestParam(value = "startDate") String startDate, 
        @RequestParam(value = "endDate") String endDate, 
        Authentication authentication){

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        
        Wallet wallet = walletService.getWalletWithTransactionsByDateRange(userDetails.getUsername(), startDate, endDate);
        
        return new WalletResponseDTO(wallet);
    }
}
