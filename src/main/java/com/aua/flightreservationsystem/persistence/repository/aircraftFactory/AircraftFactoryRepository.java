package com.aua.flightreservationsystem.persistence.repository.aircraftFactory;

import com.aua.flightreservationsystem.persistence.model.AircraftFactoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AircraftFactoryRepository extends JpaRepository<AircraftFactoryEntity, UUID> {
}
