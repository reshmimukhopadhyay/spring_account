package com.spring.account.service;

import com.spring.account.entity.BankBranch;
import com.spring.account.repository.BankBranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BankBranchService {

    @Autowired
    BankBranchRepository bankBranchRepository;

    List<BankBranch> branchList = new ArrayList<>();
    public void updateBranchDetails(BankBranch bankBranch, int branchCode){

        branchList.stream().map(bankBranchDetails->{
            if(bankBranchDetails.getBranchCode()==branchCode){
                bankBranchDetails.setBranchName(bankBranch.getBranchName());
                bankBranchDetails.setAddress(bankBranch.getAddress());
            }
            return bankBranchDetails;
        }).collect(Collectors.toList());

    }
}
