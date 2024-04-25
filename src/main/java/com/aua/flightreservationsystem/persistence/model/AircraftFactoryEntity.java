package com.aua.flightreservationsystem.persistence.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "aircraft_factory")
@Data
public class AircraftFactoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "modal_name")
    private String modalName;
}
