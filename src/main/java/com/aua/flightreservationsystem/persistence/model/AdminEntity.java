package com.aua.flightreservationsystem.persistence.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "admin")
@Data
public class AdminEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated
    @Column(name = "role_in_company")
    private RoleInCompany roleInCompany;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
