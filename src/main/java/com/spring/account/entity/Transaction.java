package com.spring.account.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;


import java.time.OffsetDateTime;
import java.util.List;

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

    @ManyToOne
    private Account account;
    @ManyToOne
    private Customer user;
    @Column(name="transaction_details")
    private String transactionDetails;

    @Enumerated(EnumType.STRING)
    @Column(name="transaction_type")
    private List<TransactionType> transactionType;
    @Column(name="credit")
    private int credit;
    @Column(name="debit")
    private int debit;
    @Column(name="balance")
    private int balance;
    @Column(name="currency")
    private String currency;
    @ManyToOne
    private BankBranch bankBranch;
    @Column(name="created_on")
    @CreationTimestamp
    private OffsetDateTime createdOn;

}
