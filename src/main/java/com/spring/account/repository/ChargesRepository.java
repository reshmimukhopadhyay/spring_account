package com.spring.account.repository;

import com.spring.account.entity.Charges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface ChargesRepository extends JpaRepository<Charges,Integer> {

    Charges getChargesByChargesId(@PathVariable int chargesId);

    Charges getChargesByChargeAmount(@PathVariable int chargesAmount);

    Charges getChargesByChargesType(@PathVariable String chargesType);


}
