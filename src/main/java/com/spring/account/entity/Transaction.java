package com.spring.account.entity;

import com.spring.account.enums.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;


import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="transaction_id")
    private int transactionId;

    /*@ManyToOne
    private Account account;*/

    @Column(name="account_number")
    private int accountNumber;
    /*@ManyToOne
    private Customer user;*/

    @Column(name="customer_id")
    private UUID customerId;

    @Column(name="transaction_details")
    private String transactionDetails;

    @Enumerated(EnumType.STRING)
    @Column(name="transaction_type")
    private TransactionType transactionType;
    @Column(name="credit")
    private int credit;
    @Column(name="debit")
    private int debit;
    @Column(name="balance")
    private int balance;
    @Column(name="currency")
    private String currency;
    /*@ManyToOne
    private BankBranch bankBranch;*/

    @Column(name="bank_branch_Code")
    private int bankBranch;


    /*@Column(name="created_on")
    @CreationTimestamp
    private OffsetDateTime createdOn;*/

}
