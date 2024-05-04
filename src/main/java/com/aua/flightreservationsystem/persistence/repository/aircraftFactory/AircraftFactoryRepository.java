package com.aua.flightreservationsystem.persistence.repository.aircraftFactory;

import com.aua.flightreservationsystem.persistence.model.AircraftFactoryEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AircraftFactoryRepository extends JpaRepository<AircraftFactoryEntity, UUID> {}
