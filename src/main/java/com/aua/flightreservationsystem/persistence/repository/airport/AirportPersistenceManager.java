package com.aua.flightreservationsystem.persistence.repository.airport;
import com.aua.flightreservationsystem.core.airport.Airport;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
public interface AirportPersistenceManager {
    List<Airport> findAllAirports();
    Optional<Airport> findAirportById(UUID id);
    Airport saveAirport(Airport airport);
    void deleteAirport(UUID id);
}
