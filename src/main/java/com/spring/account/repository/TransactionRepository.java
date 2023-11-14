package com.spring.account.repository;

import com.spring.account.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {

    Transaction getTransactionByTransactionId(@PathVariable int transactionId);
}
