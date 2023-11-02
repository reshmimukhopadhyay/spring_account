package com.spring.account.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
