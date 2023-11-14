package com.spring.account.entity;

import com.spring.account.enums.Facilities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="charges")
public class Charges {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="charges_id",unique = true)
    private int chargesId;

    @Column(name="charges_type",nullable = false)
    private String chargesType;

    @Column(name="charges",nullable = false)
    private int chargeAmount;

    @Column(name="account_type",nullable = false)
    private String accountType;

    @Enumerated(EnumType.STRING)
    @Column(name="facilities",nullable = false)
    private Facilities facilities;

    /*@OneToOne(mappedBy = "charges")
    private AccountType accountType;*/

}
