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
        if(account.getAccountNumber()!=null && account.getBranchCode()!=null && account.getCustomerId()!=null && account.getUserAuthenticationId()!=null) {
            return accountRepository.save(account);
        }else{
            throw new RuntimeException("Field should not be null");
        }

    }

    public Account findAccountByAccountNumber(Integer accountNumber) {
        if(accountNumber!=null) {
            return accountRepository.findAccountByAccountNumber(accountNumber);
        }else{
            throw new RuntimeException("Account Number should not be null");
        }
       }

    public Account findAccountByCustomerId(UUID customerId){
        if(!customerId.toString().isEmpty() && !customerId.toString().isBlank()) {
            return accountRepository.findAccountByCustomerId(customerId);
        }else if(customerId.toString()!=null){
            return accountRepository.findAccountByCustomerId(customerId);
        }else{
            throw new RuntimeException("Customer Id should not be null");
        }
    }
}
