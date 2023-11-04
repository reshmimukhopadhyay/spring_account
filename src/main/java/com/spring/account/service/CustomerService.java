package com.spring.account.service;

import com.spring.account.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository userRepository;

    public UUID getUserUUIDByUserNameAndPassword(String username,String password){
        UUID userUUID=userRepository.getUserUUIDByNameAndPassword(username,password);
        return userUUID;
    }
}
