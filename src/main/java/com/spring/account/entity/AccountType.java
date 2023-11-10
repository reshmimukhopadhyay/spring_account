package com.spring.account.entity;

import jakarta.persistence.*;
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
    @Column(name="account_type_id")
    private Integer accountTypeId;

    @Column(name="account_type",nullable = false)
    private String accountType;

    @Column(name="monthly_avg_balance",nullable = false)
    private Integer monthlyAvgBalance;

    /*@OneToOne
    private InterestRate interestRate;*/

    @Column(name="rate_of_interest_%",nullable = false)
    private Integer interestRate;

    /*@OneToOne
    private Charges charges;*/

    @Column(name="charge",nullable = false)
    private Integer charges;

    /*@OneToOne(mappedBy = "accountType")
    private Account account;*/

}
