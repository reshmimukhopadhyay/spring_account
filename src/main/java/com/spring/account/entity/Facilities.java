package com.spring.account.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="facility")
public class Facilities {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="facility_id")
    private int facilityId;

    @Column(name="facility_type")
    private String facilityType;
    @OneToOne
    private Charges charges;
}
