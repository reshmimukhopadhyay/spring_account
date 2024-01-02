package com.spring.account.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Positive;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name="account")
public class Account {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="account_id")
    private int accountId;

    @Column(name="account_number")
    @NotNull(message = "Account Number should not be null")
    @Positive
    private Integer accountNumber;

    /*@ManyToMany
    private List<UserAuthentication> userAuthentication;*/

    @Column(name="user_auth_id")
    @NotNull(message = "User Authentication id should not be null")
    private Integer userAuthenticationId;

    @Column(name="customer_id",nullable = false)
    private UUID customerId;

    /*@Enumerated(EnumType.STRING)
    @Column(name="mode_of_operation")
    private List<ModeOFOperation> modeOFOperation;*/

   /* @ManyToOne
    private BankBranch bankBranch;*/

    @Column(name="branch_code",nullable = false)
    private String branchCode;

    /*@OneToMany(mappedBy = "account")
    private List<Transaction> transactions;*/

    /*@OneToOne
    @JoinColumn(name="verification_id")
    private CustomerVerification customerVerification;
*/
    @Column(name="kyc_updated")
    private boolean kycUpdated;

   /* @OneToOne
    @JoinColumn(name="account_type_id")
    private AccountType accountType;*/

    @Column(name="account_type")
    private String accountType;
}
