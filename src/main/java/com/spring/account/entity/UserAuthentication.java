package com.spring.account.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user_authentication")
public class UserAuthentication  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_auth_id")
    private Integer userAuthId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="customer_id",referencedColumnName = "customer_id")
    private Customer customer;

    @Column(name="username",length = 50)
    private String username;

    @Column(name="password",length = 10)
    private String password;

    @ManyToMany(mappedBy = "userAuthentication")
    private List<Account> account;


}
