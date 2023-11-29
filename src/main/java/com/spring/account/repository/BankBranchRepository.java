package com.spring.account.repository;

import com.spring.account.entity.BankBranch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankBranchRepository extends JpaRepository<BankBranch,Integer> {

    BankBranch findBankBranchByBranchCode(long branchCode);
}
