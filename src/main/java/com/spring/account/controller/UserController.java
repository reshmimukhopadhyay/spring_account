package com.spring.account.controller;

import com.spring.account.entity.Customer;
import com.spring.account.repository.CustomerRepository;
import com.spring.account.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    CustomerRepository userRepository;

    @Autowired
    CustomerService userService;

    @PostMapping("/register")
    public ResponseEntity<Customer> register(@RequestBody Customer user){
        //String encodedPassword=
        userRepository.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/login")
    public UUID login(@RequestParam String username, @RequestParam String password){
        return userService.getUserUUIDByUserNameAndPassword(username,password);
    }
}
