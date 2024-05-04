package com.aua.flightreservationsystem.persistence.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "aircraft")
@Data
public class AircraftEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "model_name")
    private String modelName;

    @Column(name = "number_of_seats")
    private Short numberOfSeats;

    @ManyToOne
    @JoinColumn(name = "aircraft_factory_id")
    private AircraftFactoryEntity aircraftFactory;
}
