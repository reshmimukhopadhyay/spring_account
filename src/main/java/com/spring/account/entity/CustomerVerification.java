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
    private String pan;
    private Long adhaar;
    private VerificationStatus verificationStatus;
}
