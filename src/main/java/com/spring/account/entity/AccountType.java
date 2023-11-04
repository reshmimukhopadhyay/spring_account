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
    private int account_type_id;

    @Column(name="account_type")
    private String accountType;

    @Column(name="monthly_avg_balance")
    private int monthlyAvgBalance;

    @OneToOne
    private InterestRate interestRate;

    @OneToOne
    private Charges charges;

}
