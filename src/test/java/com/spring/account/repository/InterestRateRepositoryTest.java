package com.spring.account.repository;

import com.spring.account.entity.InterestRate;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(connection= EmbeddedDatabaseConnection.H2)
public class InterestRateRepositoryTest {

    @Autowired
    private InterestRateRepository interestRateRepository;

    @Test
    public void interestRateRepository_SaveInterestRate_ReturnNotNull(){
        InterestRate interestRate = InterestRate.builder().rateOfInterestPerAnum(6).accountBalance(100000).build();
        InterestRate savedInterestRate=interestRateRepository.save(interestRate);
        Assertions.assertThat(savedInterestRate).isNotNull();
    }

    @Test
    public void interestRateRepository_FindAllInterestRate_ReturnNotNull(){
        InterestRate interestRate1 = InterestRate.builder().rateOfInterestPerAnum(6).accountBalance(100000).build();
        InterestRate interestRate2 = InterestRate.builder().rateOfInterestPerAnum(8).accountBalance(200000).build();

         interestRateRepository.save(interestRate1);
         interestRateRepository.save(interestRate2);

        List<InterestRate> findInterestRate = interestRateRepository.findAll();
        Assertions.assertThat(findInterestRate.size()).isEqualTo(2);
    }
}
