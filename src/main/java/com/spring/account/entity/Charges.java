package com.spring.account.entity;

import com.spring.account.enums.Facilities;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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

    @Column(name="charges_type")
    @NotNull(message="Charges Type should not be null")
    @NotBlank(message="Charges Type should not be blank")
    private String chargesType;

    @Column(name="charges")
    @NotNull(message="Charge Amount Type should not be null")
    @NotBlank(message="Charge Amount Type should not be blank")
    @Positive
    private Integer chargeAmount;

    @Column(name="account_type")
    @NotNull(message="Account Type should not be null")
    @NotBlank(message="Account Type should not be blank")
    private String accountType;

    @Enumerated(EnumType.STRING)
    @Column(name="facilities")
    @NotNull(message="Facilities should not be null")
    @NotBlank(message="Facilities should not be blank")
    private Facilities facilities;

    /*@OneToOne(mappedBy = "charges")
    private AccountType accountType;*/

}
