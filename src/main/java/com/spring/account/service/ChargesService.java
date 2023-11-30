package com.spring.account.service;

import com.spring.account.entity.Charges;
import com.spring.account.repository.ChargesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChargesService {


    ChargesRepository chargesRepository;

    @Autowired
    public ChargesService(ChargesRepository chargesRepository){
        this.chargesRepository=chargesRepository;
    }


    public Charges createCharges(Charges charges){
        return chargesRepository.save(charges);
    }

    public List<Charges> getCharges(){
        return chargesRepository.findAll();
    }

    public Charges getChargesById(int chargesId){
        return chargesRepository.getChargesByChargesId(chargesId);
    }


    public List<Charges> getChargesByAmount(int chargesAmount){
        return chargesRepository.getChargesByChargeAmount(chargesAmount);
    }


}
