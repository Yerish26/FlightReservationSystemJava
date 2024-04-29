package com.aua.flightreservationsystem.persistence.repository.airline;
import com.aua.flightreservationsystem.core.airline.Airline;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AirlinePersistenceManager {
    List<Airline> findAllAirlines();
    Optional<Airline> findAirlineById(UUID id);
    Airline saveAirline(Airline airline);
    void deleteAirline(UUID id);
}
