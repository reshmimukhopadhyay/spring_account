package com.spring.account.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

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
    @NotNull(message = "Customer Id should not be null")
    @NotBlank(message = "Customer Id should not be blank")
    private UUID customerId;

    @Column(name="username",length = 50)
    @NotNull (message = "Username should not be null")
    @NotBlank (message = "Username should not be blank")
    @UniqueElements (message = "Username should not be similar")
    private String username;

    @Column(name="password", nullable = false)
    @NotNull (message = "Password should not be null")
    @NotBlank (message = "Password should not be blank")
    @UniqueElements (message = "Password should not be similar")
    private String password;

    /*@ManyToMany(mappedBy = "userAuthentication")
    private List<Account> account;*/


}
