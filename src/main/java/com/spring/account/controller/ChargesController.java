package com.spring.account.controller;


import com.spring.account.entity.Charges;
import com.spring.account.repository.ChargesRepository;
import com.spring.account.service.ChargesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/customer/bankCharges")
public class ChargesController {

    @Autowired
    ChargesRepository chargesRepository;

    @Autowired
    ChargesService chargesService;

    @PostMapping("/addCharges")
    public ResponseEntity<Charges> addCharges(@RequestBody Charges charges){
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
    public List<Charges> getChargesByAmount(@PathVariable int chargesAmount){
        return chargesService.getChargesByAmount(chargesAmount);
    }

}
