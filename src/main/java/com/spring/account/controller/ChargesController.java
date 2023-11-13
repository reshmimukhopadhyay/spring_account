package com.spring.account.controller;


import com.spring.account.entity.Charges;
import com.spring.account.repository.ChargesRepository;
import com.spring.account.service.ChargesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/customer/bankCharges")
public class ChargesController {

    @Autowired
    ChargesRepository chargesRepository;

    @Autowired
    ChargesService chargesService;

    @PostMapping("/addCharges")
    public ResponseEntity<Charges> addCharges(Charges charges){
        chargesRepository.save(charges);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getAllCharges")
    public List<Charges> getListOfCharges(){
        return chargesRepository.findAll();
    }

    @GetMapping("/getChargesById/{chargesId}")
    public Charges getChargesById(@PathVariable int chargesId){
        return chargesService.getChargesById(chargesId);
    }

    @GetMapping("/getChargesByAmount/{chargesAmount}")
    public Charges getChargesByAmount(@PathVariable int chargesAmount){
        return chargesService.getChargesByAmount(chargesAmount);
    }

    @GetMapping("/getChargesByType/{chargesType}")
    public Charges GetChargesByChargesType(@PathVariable String chargesType){
        return chargesService.getChargesByChargesType(chargesType);
    }
}
