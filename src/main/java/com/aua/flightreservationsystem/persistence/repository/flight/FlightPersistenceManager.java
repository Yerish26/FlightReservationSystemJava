package com.aua.flightreservationsystem.persistence.repository.flight;

import com.aua.flightreservationsystem.core.flight.Flight;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FlightPersistenceManager {
    List<Flight> findAll();

    Optional<Flight> findById(UUID id);

    Flight save(Flight flight);

    void delete(UUID id);
}
