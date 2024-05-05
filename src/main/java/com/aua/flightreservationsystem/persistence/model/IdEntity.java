package com.aua.flightreservationsystem.persistence.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.Data;

@MappedSuperclass()
@Data
public class IdEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;
}
