package com.aua.flightreservationsystem.persistence.model;

import jakarta.persistence.*;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "airline")
@Data
public class AirlineEntity extends BaseEntity {
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "airline")
    private List<FlightEntity> flights;

    @OneToMany(mappedBy = "airline")
    private List<AircraftEntity> aircrafts;
}
