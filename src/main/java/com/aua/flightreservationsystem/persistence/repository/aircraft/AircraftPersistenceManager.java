package com.aua.flightreservationsystem.persistence.repository.aircraft;

import com.aua.flightreservationsystem.core.aircraft.Aircraft;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AircraftPersistenceManager {
    List<Aircraft> findAll();
    Optional<Aircraft> findById(UUID id);
    Aircraft save(Aircraft aircraft);
    void delete(UUID id);
}
