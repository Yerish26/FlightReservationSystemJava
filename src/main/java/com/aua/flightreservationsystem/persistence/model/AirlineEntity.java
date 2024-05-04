package com.aua.flightreservationsystem.persistence.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;
import lombok.Data;

@Entity
@Table(name = "airline")
@Data
public class AirlineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "airline")
    private List<FlightEntity> flights;
}
