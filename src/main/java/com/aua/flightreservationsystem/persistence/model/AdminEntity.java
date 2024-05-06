package com.aua.flightreservationsystem.persistence.model;

import jakarta.persistence.*;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

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

    @ManyToMany(mappedBy = "adminUpdated")
    List<FlightEntity> flightsUpdated;

    @ManyToMany(mappedBy = "adminDeleted")
    List<FlightEntity> flightsDeleted;
}
