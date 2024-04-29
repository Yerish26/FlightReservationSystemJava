package com.aua.flightreservationsystem.persistence.repository.aircraft;

import com.aua.flightreservationsystem.core.aircraft.Aircraft;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AircraftPersistenceManager {
    List<Aircraft> findAllAircrafts();
    Optional<Aircraft> findAircraftById(UUID id);
    Aircraft saveAircraft(Aircraft aircraft);
    void deleteAircraft(UUID id);
}
