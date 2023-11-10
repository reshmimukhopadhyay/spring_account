package com.spring.account.service;

import com.spring.account.entity.Customer;
import com.spring.account.entity.UserAuthentication;
import com.spring.account.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;



    /*@Transactional
    public Customer registerCustomer(Customer customer) {
       // BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder()
        UserAuthentication userAuthentication = new UserAuthentication();
        userAuthentication.setCustomer(customer);
        customer.setUserAuthentication(userAuthentication);
        return customerRepository.save(customer);

    }*/





}
