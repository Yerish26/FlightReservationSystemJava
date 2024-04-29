package com.aua.flightreservationsystem.persistence.repository.flight;

import com.aua.flightreservationsystem.core.flight.Flight;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FlightPersistenceManager {
    List<Flight> findAllFlights();
    Optional<Flight> findById(UUID id);
    Flight saveFlight(Flight flight);
    void deleteFlight(UUID id);

}
