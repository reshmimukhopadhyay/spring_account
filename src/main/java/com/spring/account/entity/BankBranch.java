package com.spring.account.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    private Integer branchCode;

    @Column(name="branch_name")
    @NotNull (message="Branch Name should not be null")
    @NotBlank (message="Branch Name should not be blank")
    private String branchName;

    @Column(name="ifsc_code")
    @NotNull (message="IFSC should not be null")
    @NotBlank (message="IFSC should not be blank")
    private String ifsc;

    @Column(name="micr_code")
    @NotNull (message="MICR should not be null")
    @NotBlank (message="MICR should not be blank")
    private String micrCode;

    @Column(name="address")
    @NotNull (message="Address should not be null")
    @NotBlank (message="Address should not be blank")
    private String address;

    /*@OneToMany(mappedBy = "bankBranch")
    private List<Account> account;*/

    /*@OneToMany(mappedBy = "bankBranch")
    private List<Transaction> transactions;*/
}
