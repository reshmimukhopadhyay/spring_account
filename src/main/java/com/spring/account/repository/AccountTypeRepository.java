package com.spring.account.repository;

import com.spring.account.entity.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType,Integer> {

    AccountType findAccountTypeByAccountTypeId(Integer accountTypeId);

    @Query(value="select at.accountType from AccountType at where at.accountTypeId=:accountTypeId")
    String findOnlyAccountTypeByAccountTypeId(@RequestParam Integer accountTypeId);

    @Modifying
    @Query(value="update AccountType at set at.charges=:charges, at.interestRate=:interestRate, at.monthlyAvgBalance=:monthlyAvgBalance where at.accountTypeId=:accountTypeId")
    Void updateAccountCharges(@RequestBody Integer charges, @RequestBody Integer interestRate, @RequestBody Integer monthlyAvgBalance, @RequestBody Integer accountTypeId);


}
