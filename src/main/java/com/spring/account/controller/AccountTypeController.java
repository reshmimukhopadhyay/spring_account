package com.spring.account.controller;

import com.spring.account.entity.AccountType;
import com.spring.account.repository.AccountTypeRepository;
import com.spring.account.service.AccountTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/customer/accountType")
public class AccountTypeController {


    @Autowired
    private AccountTypeRepository accountTypeRepository;

    @Autowired
    private AccountTypeService accountTypeService;

    /*@Autowired
    public AccountTypeController(AccountTypeRepository accountTypeRepository,AccountTypeService accountTypeService){
        this.accountTypeService = accountTypeService;
        this.accountTypeRepository = accountTypeRepository;
    }*/

    @PostMapping("/addAccountType")
    public ResponseEntity<AccountType> addAccountType(@RequestBody @Validated AccountType accountType){
        accountTypeRepository.save(accountType);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getAllAccountType")
    public List<AccountType> getListOfAccountType(){
        return accountTypeRepository.findAll();
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
    public AccountType updateAccountTypeFields(@RequestBody @Validated AccountType accountType, @PathVariable @Validated Integer accountTypeId){
        accountTypeService.updateAccountTypeDetailsByAccountTypeId(accountType,accountTypeId);
        return accountType;
    }

    @DeleteMapping("/deleteAccountType/{accountTypeId}")
    public void deleteAccountTypeById(@PathVariable Integer accountTypeId){
        accountTypeService.deleteAccountTypeByAccountTypeId(accountTypeId);
    }

}
