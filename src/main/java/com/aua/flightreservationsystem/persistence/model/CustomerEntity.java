package com.aua.flightreservationsystem.persistence.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "customer")
@Data
public class CustomerEntity {
    @Id
    private UUID id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "registration_date")
    private Date registrationDate;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
