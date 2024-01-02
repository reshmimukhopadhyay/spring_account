package com.spring.account.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="account_type")
public class AccountType {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="account_type_id",updatable = false)
    private Integer accountTypeId;

    @Column(name="account_type")
    @NotNull(message="Account Type should not be null")
    @NotBlank(message="Account Type should not be blank")
    private String accountType;

    @Column(name="monthly_avg_balance")
    @NotNull(message="Monthly Average Balance should not be null")
    @NotBlank(message="Monthly Average Balance should not be blank")
    private Integer monthlyAvgBalance;

    /*@OneToOne
    private InterestRate interestRate;*/

    @Column(name="rate_of_interest_%")
    @NotNull(message="Interest Rate should not be null")
    @NotBlank(message="Interest Rate should not be blank")
    private Integer interestRate;

    /*@OneToOne
    private Charges charges;*/

    @Column(name="charge")
    @NotNull(message="Charges should not be null")
    @NotBlank(message="Charges should not be blank")
    private Integer charges;

    /*@OneToOne(mappedBy = "accountType")
    private Account account;*/

}
