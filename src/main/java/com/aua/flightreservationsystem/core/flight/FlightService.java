package com.aua.flightreservationsystem.core.flight;

import com.aua.flightreservationsystem.core.flight.exceptions.FlightAlreadyExistsException;
import com.aua.flightreservationsystem.persistence.repository.flight.FlightPersistenceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {
    private final FlightPersistenceManager flightPersistenceManager;

    @Autowired
    public FlightService(FlightPersistenceManager flightPersistenceManager) {
        this.flightPersistenceManager = flightPersistenceManager;
    }

    public List<Flight> getAllFlights() {
        return flightPersistenceManager.findAllFlights();
    }

    public Optional<Flight> getFlightById(Long flightId) {
        return flightPersistenceManager.findById(flightId);
    }

    public Flight saveFlight(Flight flight) throws FlightAlreadyExistsException {
        if(flightPersistenceManager.findById(flight.getFlightId()).isPresent()) {
            throw new FlightAlreadyExistsException(flight.getFlightId());
        }
        return flightPersistenceManager.saveFlight(flight);
    }

    public Flight updateFlight(Flight flight) {
        return flightPersistenceManager.saveFlight(flight);
    }

    public void deleteFlight(Long flightId){
        flightPersistenceManager.deleteFlight(flightId);
    }

}
