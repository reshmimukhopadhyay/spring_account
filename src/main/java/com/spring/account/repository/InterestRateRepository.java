package com.spring.account.repository;

import com.spring.account.entity.InterestRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterestRateRepository extends JpaRepository<InterestRate,Integer> {


}
