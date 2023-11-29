package com.spring.account.repository;

import com.spring.account.entity.BankBranch;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class BankBranchRepositoryTest {

    @Autowired
    private BankBranchRepository bankBranchRepository;

    @Test
    public void bankBranchRepo_addBankBranch_ReturnNotNull(){
        BankBranch bankBranch = BankBranch.builder().branchCode(2024).branchName("Sholling")
                .micrCode("SB9023")
                .ifsc("SB00001")
                .address("Test Address")
                .build();

        BankBranch savedBankBranch = bankBranchRepository.save(bankBranch);

        Assertions.assertThat(savedBankBranch).isNotNull();

    }

    @Test
    public void bankBranchRepo_updateBankBranch_ReturnNotNull(){
        BankBranch bankBranch = BankBranch.builder().branchCode(2024).branchName("Sholling")
                .micrCode("SB9023")
                .ifsc("SB00001")
                .address("Test Address")
                .build();

        BankBranch savedBankBranch = bankBranchRepository.save(bankBranch);

        BankBranch bankBranchId = bankBranchRepository.findBankBranchByBranchCode(savedBankBranch.getBranchCode());

        Assertions.assertThat(bankBranchId).isNotNull();
    }
}
