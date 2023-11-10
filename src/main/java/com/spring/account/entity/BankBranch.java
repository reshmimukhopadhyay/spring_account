package com.spring.account.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="bank_branch")
public class BankBranch {

    @Id
    @Column(name="branch_code")
    private long branchCode;

    @Column(name="branch_name")
    private String branchName;

    @Column(name="ifsc_code")
    private String ifsc;

    @Column(name="micr_code")
    private String micrCode;

    @Column(name="address")
    private String address;

    /*@OneToMany(mappedBy = "bankBranch")
    private List<Account> account;*/

    /*@OneToMany(mappedBy = "bankBranch")
    private List<Transaction> transactions;*/
}
