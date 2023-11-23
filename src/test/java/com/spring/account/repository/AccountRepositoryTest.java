package com.spring.account.repository;

import com.spring.account.entity.Account;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.UUID;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;


    @Test
    public void accountRepository_SaveAccountData_ReturnNotNull(){
        UUID id = UUID.randomUUID();
        Account account = Account.builder().accountType("Savings").accountNumber(12345).customerId(id).branchCode(2045).kycUpdated(true).build();
        Account savedAccount = accountRepository.save(account);
        Assertions.assertThat(savedAccount).isNotNull();
    }


    @Test
    public void accountRepository_findAccountByAccountNumber_ReturnNotNull(){
        UUID id = UUID.randomUUID();
        Account account = Account.builder().accountType("Savings").accountNumber(12345).customerId(id).branchCode(2045).kycUpdated(true).build();
        Account savedAccount = accountRepository.save(account);

        Account accountId= accountRepository.findAccountByAccountNumber(savedAccount.getAccountNumber());
        Assertions.assertThat(accountId).isNotNull();
    }

    @Test
    public void accountRepository_findAccountByCustomerId_ReturnNotNull(){
        UUID id = UUID.randomUUID();
        Account account = Account.builder().accountType("Savings").accountNumber(12345).customerId(id).branchCode(2045).kycUpdated(true).build();
        Account savedAccount = accountRepository.save(account);

        Account accountCustomerId = accountRepository.findAccountByCustomerId(savedAccount.getCustomerId());
        Assertions.assertThat(accountCustomerId).isNotNull();
    }

    @Test
    public void accountRepository_updateAccount_ReturnNotNull(){
        UUID id = UUID.randomUUID();
        Account account = Account.builder().accountType("Savings").accountNumber(12345).customerId(id).branchCode(2045).kycUpdated(true).build();
        Account savedAccount = accountRepository.save(account);

        savedAccount.setBranchCode(2345);
        Assertions.assertThat(savedAccount).isNotNull();
        Assertions.assertThat(savedAccount.getBranchCode()).isEqualTo(2345);
    }


}
