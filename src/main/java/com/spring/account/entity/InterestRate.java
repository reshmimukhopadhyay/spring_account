package com.spring.account.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
    private Integer rateOfInterestId;

    @Column(name="account_balance")
    @NotNull(message="Account Balance should not be null")
    @NotBlank(message="Account Balance should not be blank")
    @Positive
    private Integer accountBalance;

    @Column(name="roi_per_annum")
    @NotNull(message="Rate Of interest should not be null")
    @NotBlank(message="Rate Of interest should not be blank")
    private Integer rateOfInterestPerAnum;

    /*@OneToOne(mappedBy = "interestRate")
    private AccountType accountType;*/


}
