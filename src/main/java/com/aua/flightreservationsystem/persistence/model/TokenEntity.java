package com.aua.flightreservationsystem.persistence.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "token")
@Data
public class TokenEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "token")
    private String token;

    @Column(name = "logged_out")
    private boolean loggedOut;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
