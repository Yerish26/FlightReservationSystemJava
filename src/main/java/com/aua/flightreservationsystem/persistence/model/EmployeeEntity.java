package com.aua.flightreservationsystem.persistence.model;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Table(name = "user")
@Data
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "salary", columnDefinition = "Decimal(10,2) default '0.0'")
    BigDecimal salary;

    @Column(name = "contact")
    String contact;
}
