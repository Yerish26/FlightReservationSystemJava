package com.aua.flightreservationsystem.persistence.model;

import jakarta.persistence.*;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "city")
@Data
public class CityEntity extends BaseEntity {
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private CountryEntity country;

    @OneToMany
    private List<FlightEntity> flights;

    @OneToOne
    private AirportEntity airport;
}
