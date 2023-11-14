package com.spring.account.service;

import com.spring.account.entity.Transaction;
import com.spring.account.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    public Transaction getTransactionById( int transactionId){
        return  transactionRepository.getTransactionByTransactionId(transactionId);
    }
}
