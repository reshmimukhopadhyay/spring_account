package com.spring.account.service;


//1. Verify if the charges details is get by passing the chargesid.
//2. Verify if the charges details is not received by passing the charges id null.
//3. Verify if the charges details is not received by passing the charges id blank.

import com.spring.account.entity.Charges;
import com.spring.account.repository.ChargesRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.spring.account.enums.Facilities.DEBIT_CARD;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ChargesServiceTest {

    @Mock
    private ChargesRepository chargesRepository;

    @InjectMocks
    private ChargesService chargesService;


    @Test
    public void chargesService_CreateCharges_ReturnCharges(){
        Charges charges = Charges.builder().chargesType("Visa Card").chargeAmount(200).accountType("Savings").facilities(DEBIT_CARD).build();

        when(chargesRepository.save(Mockito.any(Charges.class))).thenReturn(charges);
        Charges savedCharges=chargesService.createCharges(charges);

        Assertions.assertThat(savedCharges).isNotNull();
    }


    @Test
    public void chargesService_GetAllCharges_ReturnAllCharges(){
        Charges charges1 = Charges.builder().chargesType("Visa Card").chargeAmount(200).accountType("Savings").facilities(DEBIT_CARD).build();
        Charges charges2 = Charges.builder().chargesType("Ru Pay Card").chargeAmount(210).accountType("Savings").facilities(DEBIT_CARD).build();

        when(chargesRepository.findAll()).thenReturn(List.of(charges1,charges2));

        List<Charges> savedCharges = chargesService.getCharges();
        Assertions.assertThat(savedCharges.size()).isEqualTo(2);

    }


    @Test
    public void chargesServices_GetChargesById_ReturnCharges(){
        int chargesId =1;
        Charges charges = Charges.builder().chargesType("Visa Card").chargeAmount(200).accountType("Savings").facilities(DEBIT_CARD).build();

        when(chargesRepository.getChargesByChargesId(1)).thenReturn(charges);

        Charges savedCharges = chargesService.getChargesById(chargesId);
        Assertions.assertThat(savedCharges).isNotNull();

    }


    @Test
    public void chargesServices_getChargesByAmount_ReturnCharges(){
        int chargesAmount=200;

        Charges charges1 = Charges.builder().chargesType("Visa Card").chargeAmount(200).accountType("Savings").facilities(DEBIT_CARD).build();
        Charges charges2 = Charges.builder().chargesType("RuPay Card").chargeAmount(200).accountType("Savings").facilities(DEBIT_CARD).build();

        when(chargesRepository.getChargesByChargeAmount(chargesAmount)).thenReturn(List.of(charges1,charges2));

        List<Charges> savedCharges = chargesService.getChargesByAmount(chargesAmount);
        Assertions.assertThat(savedCharges.size()).isEqualTo(2);

    }








}
