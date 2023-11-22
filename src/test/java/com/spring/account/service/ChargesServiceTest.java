package com.spring.account.service;


import com.spring.account.entity.Charges;
import com.spring.account.enums.Facilities;
import com.spring.account.repository.ChargesRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static com.spring.account.enums.Facilities.DEBIT_CARD;

//1. Verify if the charges details is get by passing the chargesid.
//2. Verify if the charges details is not received by passing the charges id null.
//3. Verify if the charges details is not received by passing the charges id blank.

public class ChargesServiceTest {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private ChargesService chargesService;

    @MockBean
    private ChargesRepository chargesRepository;


    @BeforeEach
    void setup(){
        Optional<Charges> charges = Optional.of(new Charges(1,"Visa Card",200,"Savings",DEBIT_CARD));
        Mockito.when(chargesRepository.findById(1)).thenReturn(charges);
    }
    @Test
    public void getChargesDetailsForTheValidChargesId(){
        String chargesType="Visa Card";
        int chargesAmount=200;
        String accountType="Savings";
        Facilities facilities = DEBIT_CARD;
        Charges chargesById=chargesService.getChargesById(1);
        Assertions.assertEquals(chargesType,chargesById.getChargesType());
        Assertions.assertEquals(chargesAmount,chargesById.getChargeAmount());
        Assertions.assertEquals(accountType,chargesById.getAccountType());
        Assertions.assertEquals(facilities,chargesById.getFacilities());



    }


}
