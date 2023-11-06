package com.spring.account.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user_authentication")
public class UserAuthentication {

   /* @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="customer_id")
    private int customerId;*/
    @Id
    @OneToOne
    private Customer customer;

    @Column(name="username",length = 50, nullable = false)
    private String username;

    @Column(name="password",length = 10,nullable = false)
    private String password;

    @ManyToMany(mappedBy = "userAuthentication")
    private List<Account> account;


}
