package com.aua.flightreservationsystem.persistence.model;

import jakarta.persistence.*;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "flight")
@Data
public class FlightEntity extends BaseEntity {
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
