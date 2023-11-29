package com.spring.account.service;

import com.spring.account.entity.Customer;
import com.spring.account.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;


    public Customer saveCustomer(Customer customer){
       return customerRepository.save(customer);
    }

    /*@Transactional
    public Customer registerCustomer(Customer customer) {
       // BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder()
        UserAuthentication userAuthentication = new UserAuthentication();
        userAuthentication.setCustomer(customer);
        customer.setUserAuthentication(userAuthentication);
        return customerRepository.save(customer);

    }*/





}
