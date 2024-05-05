package com.aua.flightreservationsystem.persistence.model;

import jakarta.persistence.*;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "aircraft_factory")
@Data
public class AircraftFactoryEntity extends BaseEntity {
    @Column(name = "model_name")
    private String modelName;

    @OneToMany(mappedBy = "aircraftFactory")
    private List<AircraftEntity> aircrafts;
}
