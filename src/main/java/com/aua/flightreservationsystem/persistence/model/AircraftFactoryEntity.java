package com.aua.flightreservationsystem.persistence.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "aircraft_factory")
@Data
public class AircraftFactoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "model_name")
    private String modelName;

    @OneToMany(mappedBy = "aircraftFactory")
    private List<AircraftEntity> aircrafts;
}
