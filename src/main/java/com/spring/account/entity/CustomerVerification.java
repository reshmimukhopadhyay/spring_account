package com.spring.account.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="customer_verification")
public class CustomerVerification {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="verification_id")
    private int verificationId;

    @OneToOne
    private Customer customer;

    @Column(name="pan_no.")
    private String pan;
    @Column(name="adhaar")
    private Long adhaar;
    @Enumerated(EnumType.STRING)
    @Column(name="verification_status")
    private VerificationStatus verificationStatus;

    @OneToOne(mappedBy = "customerVerification")
    private Account account;
}
