package com.aua.flightreservationsystem.persistence.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.UUID;
import lombok.Data;

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
