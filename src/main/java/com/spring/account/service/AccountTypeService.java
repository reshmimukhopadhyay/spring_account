package com.spring.account.service;

import com.spring.account.entity.AccountType;
import com.spring.account.repository.AccountRepository;
import com.spring.account.repository.AccountTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountTypeService {

    @Autowired
    AccountTypeRepository accountTypeRepository;

    public void updateAccountTypeDetailsByAccountTypeId(AccountType accountType){
        AccountType accountTypeTobeUpdated = accountTypeRepository.findAccountTypeByAccountTypeId(accountType.getAccountTypeId());
        if(accountType.getAccountTypeId().)
    }
}
