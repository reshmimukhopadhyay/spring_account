package com.spring.account.service;

import com.spring.account.entity.CustomerVerification;
import com.spring.account.enums.VerificationStatus;
import com.spring.account.repository.CustomerVerificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerVerificationService {

    @Autowired
    private CustomerVerificationRepository customerVerificationRepository;

    public String verifyCustomer(CustomerVerification customerVerification){
        Optional<CustomerVerification> verifiedCustomer= customerVerificationRepository.findById(customerVerification.getVerificationId());
        if(verifiedCustomer.isPresent()){
            customerVerification.setVerificationStatus(VerificationStatus.VERIFIED);
            return "Verified";
        }else customerVerification.setVerificationStatus(VerificationStatus.PENDING);
        return "Pending";
    }


}
