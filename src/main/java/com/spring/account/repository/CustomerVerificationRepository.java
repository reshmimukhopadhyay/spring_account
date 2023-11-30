package com.spring.account.repository;

import com.spring.account.entity.CustomerVerification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerVerificationRepository extends JpaRepository<CustomerVerification,Integer> {


}
