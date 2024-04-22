package com.aua.flightreservationsystem.core.flight;

import java.util.List;
import java.util.Optional;

public interface FlightPersistenceManager {
    List<Flight> findAllFlights();
    Optional<Flight> findById(Long id);
    Flight saveFlight(Flight flight);
    void deleteFlight(Long flightId);

}
