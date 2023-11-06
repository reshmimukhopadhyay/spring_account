package com.spring.account.entity;

import com.spring.account.enums.ModeOFOperation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    private long accountNumber;

    @ManyToMany
    private List<UserAuthentication> userAuthentication;

    @Enumerated(EnumType.STRING)
    @Column(name="mode_of_operation")
    private List<ModeOFOperation> modeOFOperation;

    @ManyToOne
    private BankBranch bankBranch;

    @OneToMany(mappedBy = "account")
    private List<Transaction> transactions;

    @OneToOne
    @JoinColumn(name="verification_id")
    private CustomerVerification customerVerification;

    @OneToOne
    @JoinColumn(name="account_type_id")
    private AccountType accountType;
}
