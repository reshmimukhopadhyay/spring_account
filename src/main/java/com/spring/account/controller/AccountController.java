package com.spring.account.controller;

import com.spring.account.entity.Account;
import com.spring.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value="/customer/account")
public class AccountController {


    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService){

        this.accountService=accountService;
    }



    @PostMapping("/createAccount")
    public ResponseEntity<Account> addAccount(@RequestBody @Validated Account account) throws Exception {
        accountService.createAccount(account);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/accountDetailsByAccountNumber")
    public Account findAccountDetailsByAccountNumber(@RequestParam Integer accountNumber){
        return accountService.findAccountByAccountNumber(accountNumber);
    }

    @GetMapping("/accountDetailsByCustomerId")
    public Account findAccountDetailsByCustomerId(@RequestParam UUID customerId){
        return accountService.findAccountByCustomerId(customerId);
    }

}
