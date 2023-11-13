package com.spring.account.controller;

import com.spring.account.entity.Account;
import com.spring.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value="/customer/account")
public class AccountController {

    @Autowired
    AccountRepository accountRepository;

    @PostMapping("/createAccount")
    public ResponseEntity<Account> addAccount(@RequestBody Account account){
        accountRepository.save(account);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/accountDetailsByAccountNumber/{accountNumber}")
    public Account findAccountDetailsByAccountNumber(@PathVariable Long accountNumber){
        return accountRepository.findAccountByAccountNumber(accountNumber);
    }

    @GetMapping("/accountDetailsByCustomerId/{customerId}")
    public Account findAccountDetailsByCustomerId(@PathVariable UUID customerId){
        return accountRepository.findAccountByCustomerId(customerId);
    }

}
