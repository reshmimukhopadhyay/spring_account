package com.spring.account.entity;


import com.spring.account.enums.VerificationStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    private Integer verificationId;

    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="customer_id")
    private Customer customer;

    @Column(name="pan_no.")
    @NotNull(message="PAN should not be null")
    @NotBlank(message="PAN should not be blank")
    private String pan;
    @Column(name="adhaar")
    @NotNull(message="Adhaar should not be null")
    @NotBlank(message="Adhaar should not be blank")
    private Long adhaar;
    @Enumerated(EnumType.STRING)
    @Column(name="verification_status")
    @NotNull(message="Verification status should not be null")
    @NotBlank(message="Verification status should not be blank")
    private VerificationStatus verificationStatus;

   /* @OneToOne(mappedBy = "customerVerification")
    private Account account;*/
}
