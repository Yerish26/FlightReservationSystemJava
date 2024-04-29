package com.aua.flightreservationsystem.persistence.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "flight")
@Data
public class FlightEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "source")
    private CityEntity source;

    @ManyToOne
    @JoinColumn(name = "destination")
    private CityEntity destination;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "time")
    private Date time;

    @ManyToOne
    @JoinColumn(name = "airline_id")
    private AirlineEntity airline;
}
