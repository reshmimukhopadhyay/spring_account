package com.spring.account.controller;

import com.spring.account.entity.Customer;
import com.spring.account.repository.CustomerRepository;
import com.spring.account.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {


    CustomerRepository customerRepository;

    CustomerService customerService;

    @Autowired
    public CustomerController(CustomerRepository customerRepository,CustomerService customerService){
        this.customerRepository = customerRepository;
        this.customerService = customerService;
    }

    @PostMapping("/register")
    public ResponseEntity<Customer> register(@RequestBody Customer customer){
        customerRepository.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*@GetMapping("/login")
    public UUID login(@RequestBody Customer customer){
        return customerService.getUserUUIDByUserNameAndPassword(customer);
    }*/


}
