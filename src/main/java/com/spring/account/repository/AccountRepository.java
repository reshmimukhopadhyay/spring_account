package com.spring.account.repository;

import com.spring.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {

    Account findAccountByAccountNumber(@RequestParam Long accountNumber);

    Account findAccountByCustomerId(@RequestParam UUID customerId);
}
