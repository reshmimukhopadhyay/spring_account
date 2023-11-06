package com.spring.account.service;

import com.spring.account.entity.Customer;
import com.spring.account.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Customer registerCustomer(Customer customer) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encryptedPassword = bCryptPasswordEncoder.encode(customer.getPassword());
        customer.setPassword(encryptedPassword);
        return customerRepository.save(customer);

    }


    public UUID getUserUUIDByUserNameAndPassword(String username, String password) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        Customer customer=new Customer();
        if (bCryptPasswordEncoder.matches(password,customer.getPassword())){
            UUID customerUUID= customerRepository.getUserUUIDByNameAndPassword(username, password);
            return customerUUID;}
        return null;
    }
}
