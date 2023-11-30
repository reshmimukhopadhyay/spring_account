package com.spring.account.service;

import com.spring.account.entity.AccountType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountTypeService {


    List <AccountType>accountTypeList = new ArrayList<>();

    public void updateAccountTypeDetailsByAccountTypeId(AccountType accountType, int accountTypeId){
        accountTypeList.stream().map(at->{
            if(at.getAccountTypeId()==accountTypeId){
                at.setAccountType(accountType.getAccountType());
                at.setCharges(accountType.getCharges());
                at.setInterestRate(accountType.getInterestRate());
                at.setMonthlyAvgBalance(accountType.getMonthlyAvgBalance());
            }
            return at;
        }).collect(Collectors.toList());
    }

    public void deleteAccountTypeByAccountTypeId(int accountTypeId){
        accountTypeList.stream().filter(accountType -> accountType.getAccountTypeId()!=accountTypeId).collect(Collectors.toList());
    }
}
