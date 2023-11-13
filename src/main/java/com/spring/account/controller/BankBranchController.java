package com.spring.account.controller;

import com.spring.account.entity.BankBranch;
import com.spring.account.repository.BankBranchRepository;
import com.spring.account.service.BankBranchService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/customer/bankbranch")
public class BankBranchController {

    @Autowired
    BankBranchRepository bankBranchRepository;

    @Autowired
    BankBranchService bankBranchService;

    @PostMapping("/addBranch")
    public ResponseEntity<BankBranch> addBankBranch(BankBranch bankBranch){
        bankBranchRepository.save(bankBranch);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getBranchDetails/{branchCode}")
    public BankBranch getBankBranchById(@PathVariable int branchCode){
        return bankBranchRepository.findBankBranchByBranchCode(branchCode);
    }

    @GetMapping("/getAllBranch")
    public List<BankBranch> getAllBankBranchDetails(){
        return bankBranchRepository.findAll();
    }

    @PutMapping("/updateBankBranch/{branchCode}")
    public BankBranch updateBankBranch(@RequestBody BankBranch bankBranch, @PathVariable int branchCode){
        bankBranchService.updateBranchDetails(bankBranch,branchCode);
        return bankBranch;
    }
}
