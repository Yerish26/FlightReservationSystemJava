package com.aua.flightreservationsystem.persistence.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "aircraft")
@Data
public class AircraftEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "modal_name")
    private String modalName;

    @Column(name = "number_of_seats")
    private Short numberOfSeats;

    @ManyToOne
    @JoinColumn(name = "aircraft_factory_id")
    private AircraftFactoryEntity aircraftFactory;
}
