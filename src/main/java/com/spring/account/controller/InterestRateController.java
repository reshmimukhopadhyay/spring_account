package com.spring.account.controller;

import com.spring.account.entity.InterestRate;
import com.spring.account.repository.InterestRateRepository;
import com.spring.account.service.InterestRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/customer/interestRate")
public class InterestRateController {



    InterestRateRepository interestRateRepository;
    InterestRateService interestRateService;

    @Autowired
    public InterestRateController(InterestRateRepository interestRateRepository,InterestRateService interestRateService){
        this.interestRateRepository=interestRateRepository;
        this.interestRateService=interestRateService;
    }

    @PostMapping("/addInterestRate")
    public ResponseEntity<InterestRate> addInterestRate(InterestRate interestRate){
        interestRateRepository.save(interestRate);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/updateInterestRate")
    public InterestRate updateInterestRate(@RequestBody InterestRate interestRate, @PathVariable int interestRateId){
        interestRateService.updateInterestRate(interestRate,interestRateId);
        return interestRate;
    }
}
