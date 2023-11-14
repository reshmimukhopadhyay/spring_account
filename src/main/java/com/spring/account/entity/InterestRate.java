package com.spring.account.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="interest_Rate")
public class InterestRate {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="roi_id")
    private int rateOfInterestId;

    @Column(name="account_balance")
    private int accountBalance;

    @Column(name="roi_per_annum")
    private int rateOfInterestPerAnum;

    /*@OneToOne(mappedBy = "interestRate")
    private AccountType accountType;*/


}
