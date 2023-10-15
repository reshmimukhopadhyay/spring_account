package com.spring.account.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(name="user_name",length=50,nullable=false)
    private String name;

    @Column(name="phone_number",length=10)
    private int phoneNumber;

    @Column(name="address",length=60)
    private String address;

}
