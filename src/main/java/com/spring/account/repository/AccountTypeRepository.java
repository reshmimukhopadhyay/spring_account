package com.spring.account.repository;

import com.spring.account.entity.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType,Integer> {

    AccountType findAccountTypeByAccountTypeId(Integer accountTypeId);

    @Query(value="select at.accountType from AccountType at where at.accountTypeId=:accountTypeId")
    String findOnlyAccountTypeByAccountTypeId(Integer accountTypeId);

    @Modifying
    @Query(value="update AccountType at set at.charges=:charges, at.interestRate=:interestRate, at.monthlyAvgBalance=:monthlyAvgBalance where at.accountTypeId=:accountTypeId")
    Void updateAccountType(AccountType accountType, Integer accountTypeId);


    void deleteAccountTypeByAccountTypeId(Integer accountTypeId);
}
