package com.aua.flightreservationsystem.persistence.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "admin")
@Data
public class AdminEntity extends BaseEntity {
    @Enumerated
    @Column(name = "role_in_company")
    private RoleInCompany roleInCompany;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToMany(mappedBy = "admin")
    List<FlightEntity> flights;
}
