package com.spring.account.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(generator="UUID")
    @GenericGenerator(name="UUID",strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name="customer_id", updatable = false)
    private UUID customerId;

    @Column(name="name",length=50)
    private String name;

    @Column(name="mobile_number",length=10)
    private Long mobileNumber;

    @Column(name="email_id", length=30,unique = true)
    private String emailId;

    @Column(name="address",length=50)
    private String address;

    @Column(name="date_of_birth")
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date dateOfBirth;

    @OneToOne(mappedBy = "customer",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private UserAuthentication userAuthentication;

    @OneToMany(mappedBy = "user")
    private List<Transaction> transaction;

    public Customer(UserAuthentication saveUserAuthentication) {
        this.userAuthentication= saveUserAuthentication;

    }
}
