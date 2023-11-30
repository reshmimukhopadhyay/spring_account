package com.spring.account.service;

import com.spring.account.entity.Transaction;
import com.spring.account.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {


    TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository){
        this.transactionRepository=transactionRepository;
    }

    public Transaction getTransactionById( int transactionId){
        return  transactionRepository.getTransactionByTransactionId(transactionId);
    }
}
