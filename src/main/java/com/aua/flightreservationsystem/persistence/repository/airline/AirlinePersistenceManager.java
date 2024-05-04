package com.aua.flightreservationsystem.persistence.repository.airline;

import com.aua.flightreservationsystem.core.airline.Airline;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AirlinePersistenceManager {
    List<Airline> findAll();

    Optional<Airline> findById(UUID id);

    Airline save(Airline airline);

    void delete(UUID id);
}
