package com.spring.account;

import com.spring.account.entity.Charges;
import com.spring.account.repository.ChargesRepository;
import com.spring.account.service.ChargesService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.spring.account.enums.Facilities.DEBIT_CARD;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class AccountApplicationTests {

	@Test
	void contextLoads() {
	}


	@Autowired
	private ChargesService chargesService;

	@MockBean
	private ChargesRepository chargesRepository;

	@Test
	public void getAllChargesTest(){
		when(chargesRepository.findAll()).thenReturn(Stream.of(new Charges(1,"Visa Card",200,"Savings",DEBIT_CARD),
				new Charges(2,"Master Card",50,"Savings",DEBIT_CARD)).collect(Collectors.toList()));
		Assertions.assertEquals(2,chargesService.getCharges().size());

	}





}
