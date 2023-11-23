package com.spring.account.repository;

import com.spring.account.entity.AccountType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(connection= EmbeddedDatabaseConnection.H2)
public class AccountTypeRepositoryTest {

    @Autowired
    private AccountTypeRepository accountTypeRepository;

    @Test
    public void accountTypeRepository_saveAccountType_ReturnNotNull(){
        AccountType accountType = AccountType.builder().accountType("Savings").charges(280).monthlyAvgBalance(10000).interestRate(3).build();

        AccountType savedAccountType = accountTypeRepository.save(accountType);

        Assertions.assertThat(savedAccountType).isNotNull();
    }

    @Test
    public void accountTypeRepository_findAllAccountType_ReturnNotNull(){
        AccountType accountType1 = AccountType.builder().accountType("Savings").charges(280).monthlyAvgBalance(10000).interestRate(3).build();
        AccountType accountType2 = AccountType.builder().accountType("Savings").charges(230).monthlyAvgBalance(10000).interestRate(3).build();

         accountTypeRepository.save(accountType1);
         accountTypeRepository.save(accountType2);

        List<AccountType> accountTypeList=accountTypeRepository.findAll();
        Assertions.assertThat(accountTypeList.size()).isEqualTo(2);

    }

    @Test
    public void accountTypeRepository_findOnlyAccountTypeByAccountTypeId_ReturnNotNull(){
        AccountType accountType = AccountType.builder().accountType("Savings").charges(280).monthlyAvgBalance(10000).interestRate(3).build();

        AccountType savedAccountType = accountTypeRepository.save(accountType);
        AccountType accountTypeId = accountTypeRepository.findAccountTypeByAccountTypeId(savedAccountType.getAccountTypeId());

        Assertions.assertThat(accountTypeId).isNotNull();
        Assertions.assertThat(accountTypeId.getAccountTypeId()).isEqualTo(1);
    }


    @Test
    public void accountType_updateAccountType_ReturnNotNull(){
        AccountType accountType = AccountType.builder().accountType("Savings").charges(280).monthlyAvgBalance(10000).interestRate(3).build();

        AccountType accountTypeSaved = accountTypeRepository.save(accountType);

        accountTypeSaved.setMonthlyAvgBalance(5000);
        accountTypeRepository.save(accountTypeSaved);

        Assertions.assertThat(accountTypeSaved.getMonthlyAvgBalance()).isEqualTo(5000);
    }


}
