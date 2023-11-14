package com.spring.account.repository;

import com.spring.account.entity.Charges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface ChargesRepository extends JpaRepository<Charges,Integer> {

    Charges getChargesByChargesId(@PathVariable int chargesId);

    List<Charges> getChargesByChargeAmount(@PathVariable int chargesAmount);






}
