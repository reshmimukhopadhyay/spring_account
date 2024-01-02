package com.spring.account.service;

import com.spring.account.entity.Account;
import com.spring.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository){

        this.accountRepository=accountRepository;
    }

    public Account createAccount(Account account) throws Exception {
          return accountRepository.save(account);

    }

    public Account findAccountByAccountNumber(Integer accountNumber) {
        if(accountNumber!=null) {
            return accountRepository.findAccountByAccountNumber(accountNumber);
        }else{
            throw new RuntimeException("Account Number should not be null");
        }
       }

    public Account findAccountByCustomerId(UUID customerId){
        return accountRepository.findAccountByCustomerId(customerId);
    }
}
