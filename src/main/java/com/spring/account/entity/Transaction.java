package com.spring.account.entity;

import com.spring.account.enums.TransactionType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Integer transactionId;

    /*@ManyToOne
    private Account account;*/

    @Column(name="account_number")
    @NotNull (message = "Account Number should not be null")
    @NotBlank (message = "Account Number should not be blank")
    private Integer accountNumber;
    /*@ManyToOne
    private Customer user;*/

    @Column(name="customer_id")
    @NotNull (message = "Customer Id should not be null")
    @NotBlank (message = "Customer Id should not be blank")
    private UUID customerId;

    @Column(name="transaction_details")
    @NotNull (message = "Transaction Details should not be null")
    @NotBlank (message = "Transaction Details should not be blank")
    private String transactionDetails;

    @Enumerated(EnumType.STRING)
    @Column(name="transaction_type")
    @NotNull (message = "Transaction Type should not be null")
    @NotBlank (message = "Transaction Type should not be blank")
    private TransactionType transactionType;
    @Column(name="credit")
    @NotNull (message = "Credit should not be null")
    @NotBlank (message = "Credit should not be blank")
    private Integer credit;
    @Column(name="debit")
    @NotNull (message = "Debit should not be null")
    @NotBlank (message = "Debit should not be blank")
    private Integer debit;
    @Column(name="balance")
    @Positive
    @NotNull (message = "Balance should not be null")
    @NotBlank (message = "Balance should not be blank")
    private Integer balance;
    @Column(name="currency")
    @NotNull (message = "Currency should not be null")
    @NotBlank (message = "Currency should not be blank")
    private String currency;
    /*@ManyToOne
    private BankBranch bankBranch;*/

    @Column(name="bank_branch_Code")
    @NotNull (message = "Bank Branch should not be null")
    @NotBlank (message = "Bank Branch should not be blank")
    private Integer bankBranch;


    /*@Column(name="created_on")
    @CreationTimestamp
    private OffsetDateTime createdOn;*/

}
