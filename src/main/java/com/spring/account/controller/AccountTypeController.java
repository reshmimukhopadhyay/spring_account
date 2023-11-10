package com.spring.account.controller;

import com.spring.account.entity.AccountType;
import com.spring.account.repository.AccountTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/customer/accountType")
public class AccountTypeController {

    @Autowired
    AccountTypeRepository accountTypeRepository;

    @PostMapping("/addAccountType")
    public ResponseEntity<AccountType> addAccountType(@RequestBody AccountType accountType){
        accountTypeRepository.save(accountType);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getAccountTypeDetails/{accountTypeId}")
    public AccountType findAccountTypeDetails(@PathVariable Integer accountTypeId){
        return accountTypeRepository.findAccountTypeByAccountTypeId(accountTypeId);
    }


    @GetMapping("/getAccountTypeByTypeId/{accountTypeId}")
    public String findAccountTypeByAccountTypeId(@PathVariable Integer accountTypeId){
        return String.valueOf(accountTypeRepository.findOnlyAccountTypeByAccountTypeId(accountTypeId));
    }

    @PutMapping("/updateAccountTypeDetails/{accountTypeId}")
    public String updateAccountTypeFields(@PathVariable Integer accountTypeId){
        accountTypeRepository.updateAccountCharges(charges,interestRate,monthlyAvgBalance,accountTypeId);
        return "Data updated Successfully";
    }

}
