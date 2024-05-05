package com.aua.flightreservationsystem.persistence.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "airport")
@Data
public class AirportEntity extends BaseEntity {
    @Column(name = "name")
    private String name;

    @OneToOne
    @JoinColumn(name = "city_id")
    CityEntity city;
}
