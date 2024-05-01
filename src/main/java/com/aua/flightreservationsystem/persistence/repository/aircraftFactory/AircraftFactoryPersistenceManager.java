package com.aua.flightreservationsystem.persistence.repository.aircraftFactory;

import com.aua.flightreservationsystem.core.aircraftFactory.AircraftFactory;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AircraftFactoryPersistenceManager {
    List<AircraftFactory> findAll();
    Optional<AircraftFactory> findById(UUID id);
    AircraftFactory save(AircraftFactory aircraftFactory);
    void delete(UUID id);
}
