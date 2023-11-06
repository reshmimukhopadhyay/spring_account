package com.spring.account.entity;


import com.spring.account.enums.VerificationStatus;
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

    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="customer_id")
    private Customer customer;

    @Column(name="pan_no.",nullable = false)
    private String pan;
    @Column(name="adhaar",nullable = false)
    private Long adhaar;
    @Enumerated(EnumType.STRING)
    @Column(name="verification_status")
    private VerificationStatus verificationStatus;

    @OneToOne(mappedBy = "customerVerification")
    private Account account;
}
