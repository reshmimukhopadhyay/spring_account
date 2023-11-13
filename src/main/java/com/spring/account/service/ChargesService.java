package com.spring.account.service;

import com.spring.account.entity.Charges;
import com.spring.account.repository.ChargesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChargesService {

    @Autowired
    ChargesRepository chargesRepository;

    public Charges getChargesById(int chargesId){
        return chargesRepository.getChargesByChargesId(chargesId);
    }


    public Charges getChargesByAmount(int chargesAmount){
        return chargesRepository.getChargesByChargeAmount(chargesAmount);
    }


    public Charges getChargesByChargesType(String chargesType){
        return chargesRepository.getChargesByChargesType(chargesType);
    }
}
