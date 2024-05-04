package com.aua.flightreservationsystem.persistence.repository.airport;

import com.aua.flightreservationsystem.core.airport.Airport;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AirportPersistenceManager {
    List<Airport> findAll();

    Optional<Airport> findById(UUID id);

    Airport save(Airport airport);

    void delete(UUID id);
}
