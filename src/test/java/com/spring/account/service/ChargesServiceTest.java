package com.spring.account.service;


import com.spring.account.entity.Charges;
import com.spring.account.repository.ChargesRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.spring.account.enums.Facilities.DEBIT_CARD;
import static org.mockito.Mockito.when;

//1. Verify if the charges details is get by passing the chargesid.
//2. Verify if the charges details is not received by passing the charges id null.
//3. Verify if the charges details is not received by passing the charges id blank.
public class ChargesServiceTest {


    @InjectMocks
    ChargesService chargesService;

    @Mock
    ChargesRepository chargesRepository;




    @Test
    void getChargesDetailsForTheValidChargesId(){
        when(chargesRepository.findAll()).thenReturn(Stream.of(new Charges(1,"Visa Card",200,"Saving",DEBIT_CARD)).collect(Collectors.toList()));
        Assertions.assertEquals(1,chargesService.getChargesById(1));

    }


}
