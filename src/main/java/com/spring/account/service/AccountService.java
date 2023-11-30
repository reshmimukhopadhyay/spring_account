package com.spring.account.service;

import com.spring.account.entity.Account;
import com.spring.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository){
        this.accountRepository=accountRepository;
    }

    public Account createAccount(Account account){
        return accountRepository.save(account);

    }

    public Account findAccountByAccountNumber(Long accountNumber){
       return accountRepository.findAccountByAccountNumber(accountNumber);
    }

    public Account findAccountByCustomerId(@RequestParam UUID customerId){
        return accountRepository.findAccountByCustomerId(customerId);
    }
}
