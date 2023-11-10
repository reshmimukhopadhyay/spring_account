package com.spring.account.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

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

    /*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="customer_id",referencedColumnName = "customer_id")*/

    @Column(name="customer_Id")
    private UUID customerId;

    @Column(name="username",length = 50, unique = true, nullable = false)
    private String username;

    @Column(name="password", nullable = false)
    private String password;

    /*@ManyToMany(mappedBy = "userAuthentication")
    private List<Account> account;*/


}
