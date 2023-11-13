package com.spring.account.entity;

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
    @Column(name="charges_id")
    private int chargesId;

    @Column(name="charges_type")
    private String ChargesType;

    @Column(name="charges")
    private int chargeAmount;

    /*@OneToOne(mappedBy = "charges")
    private AccountType accountType;*/

    /*@OneToOne(mappedBy = "charges")
    private Facilities facilities;*/
}
