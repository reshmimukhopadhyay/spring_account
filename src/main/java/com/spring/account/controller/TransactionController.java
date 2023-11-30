package com.spring.account.controller;

import com.spring.account.entity.Transaction;
import com.spring.account.repository.TransactionRepository;
import com.spring.account.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/customer/bankTransaction")
public class TransactionController {


    TransactionRepository transactionRepository;
    TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionRepository transactionRepository,TransactionService transactionService){
        this.transactionRepository=transactionRepository;
        this.transactionService=transactionService;

    }

    @PostMapping("/createTransaction")
    public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction transaction){
        transactionRepository.save(transaction);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("/{transactionId}")
    public Transaction getTransactionDetailsById(@PathVariable int transactionId){
        return transactionService.getTransactionById(transactionId);
    }
}
