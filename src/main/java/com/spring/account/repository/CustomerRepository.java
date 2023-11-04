package com.spring.account.repository;

import com.spring.account.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

   @Query(value="select u.customerId from Customer u where u.username=(:username) and u.password=(:password)" )
   UUID getUserUUIDByNameAndPassword(@RequestParam String username,@RequestParam String password);
}
