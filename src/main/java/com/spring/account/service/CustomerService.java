package com.spring.account.service;

import com.spring.account.entity.Customer;
import com.spring.account.entity.UserAuthentication;
import com.spring.account.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;


    @Transactional
    public Customer registerCustomer(Customer customer) {
       // BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder()
        ;
        UserAuthentication userAuthentication = new UserAuthentication();
        userAuthentication.setCustomer(customer);
        customer.setUserAuthentication(userAuthentication);
        return customerRepository.save(customer);

    }



   /* public UUID getUserUUIDByUserNameAndPassword(Customer customer) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        Optional<Customer> getCustomerByUsername = customerRepository.getCustomerByUsername(customer.getUsername());
        if (!getCustomerByUsername.isEmpty()) {
            Customer databaseCustomer = getCustomerByUsername.get();
            if (bCryptPasswordEncoder.matches(customer.getPassword(), databaseCustomer.getPassword())) {
                UUID customerUUID = customer.getCustomerId();
                return customerUUID;
            }
        }
        return null;
    }*/
}
