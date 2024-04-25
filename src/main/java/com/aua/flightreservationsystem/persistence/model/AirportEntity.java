package com.aua.flightreservationsystem.persistence.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "airport")
@Data
public class AirportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @OneToOne
    @JoinColumn(name = "city_id")
    CityEntity city;
}