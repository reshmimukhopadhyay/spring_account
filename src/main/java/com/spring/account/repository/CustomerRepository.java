package com.spring.account.repository;

import com.spring.account.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,UUID> {


    Optional<Customer> findCustomerByCustomerId(@PathVariable UUID customerId);
    Optional<Customer> findCustomerByEmailId(@PathVariable String emailId);


}
