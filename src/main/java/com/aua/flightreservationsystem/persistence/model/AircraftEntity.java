package com.aua.flightreservationsystem.persistence.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "aircraft")
@Data
public class AircraftEntity extends BaseEntity {
    @Column(name = "model_name")
    private String modelName;

    @Column(name = "number_of_seats")
    private Short numberOfSeats;

    @ManyToOne
    @JoinColumn(name = "aircraft_factory_id")
    private AircraftFactoryEntity aircraftFactory;

    @ManyToOne
    @JoinColumn(name = "airline_id")
    private AirlineEntity airline;
}
