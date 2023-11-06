package com.spring.account.controller;

import com.spring.account.entity.Customer;
import com.spring.account.entity.UserAuthentication;
import com.spring.account.repository.CustomerRepository;
import com.spring.account.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.UUID;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<Customer> register(@RequestBody Customer customer){
        customerRepository.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/login")
    public UUID login(@RequestParam String username, @RequestParam String password){
        return customerService.getUserUUIDByUserNameAndPassword(username,password);
    }
}
