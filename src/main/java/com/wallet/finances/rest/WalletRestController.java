package com.wallet.finances.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wallet.finances.services.WalletService;

@RestController
@RequestMapping("/wallet")
public class WalletRestController {

    @Autowired
    WalletService walletService;
    
   
}
