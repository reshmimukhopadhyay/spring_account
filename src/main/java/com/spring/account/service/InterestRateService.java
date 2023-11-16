package com.spring.account.service;

import com.spring.account.entity.InterestRate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InterestRateService {

    List<InterestRate> interestRateList = new ArrayList<>();
    public void updateInterestRate(InterestRate interestRate, int interestRateId){
        interestRateList.stream().map(itr->{
            if(itr.getRateOfInterestId()==interestRateId){
                itr.setRateOfInterestPerAnum(interestRate.getRateOfInterestPerAnum());
            }
            return itr;
        }).collect(Collectors.toList());

    }
}
