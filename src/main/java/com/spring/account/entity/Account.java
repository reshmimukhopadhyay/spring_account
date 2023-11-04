package com.spring.account.entity;

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

    @ManyToOne
    private BankBranch bankBranch;
}
