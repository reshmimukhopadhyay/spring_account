package com.spring.account.controller;

import com.spring.account.entity.CustomerVerification;
import com.spring.account.enums.VerificationStatus;
import com.spring.account.repository.CustomerVerificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerVerificationController {

    @Autowired
    private CustomerVerificationRepository customerVerificationRepository;

    @PostMapping("/verify_customer")
    public ResponseEntity<VerificationStatus> addVerificationStatus(CustomerVerification customerVerification){
        customerVerificationRepository.save(customerVerification);
        return new ResponseEntity<>(HttpStatus.OK);

    }


}
