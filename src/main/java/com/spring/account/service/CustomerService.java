package com.spring.account.service;

import com.spring.account.entity.Customer;
import com.spring.account.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService {


    CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }

    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public List<Customer> findAllCustomer(){
        return customerRepository.findAll();
    }

    public Optional<Customer> findCustomerById(UUID customerId){
        return customerRepository.findCustomerByCustomerId(customerId);
    }

    public Optional<Customer> findCustomerByEmailId(String emailId){
        return customerRepository.findCustomerByEmailId(emailId);
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
