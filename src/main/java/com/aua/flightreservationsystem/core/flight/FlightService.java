package com.aua.flightreservationsystem.core.flight;

import com.aua.flightreservationsystem.core.flight.exceptions.FlightAlreadyExistsException;
import com.aua.flightreservationsystem.persistence.repository.flight.FlightPersistenceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FlightService {
    private final FlightPersistenceManager flightPersistenceManager;

    @Autowired
    public FlightService(FlightPersistenceManager flightPersistenceManager) {
        this.flightPersistenceManager = flightPersistenceManager;
    }

    public List<Flight> getAll() {
        return flightPersistenceManager.findAll();
    }

    public Optional<Flight> getById(UUID id) {
        return flightPersistenceManager.findById(id);
    }

    public Flight save(Flight flight) throws FlightAlreadyExistsException {
        if(flightPersistenceManager.findById(flight.getId()).isPresent()) {
            throw new FlightAlreadyExistsException(flight.getId());
        }
        return flightPersistenceManager.save(flight);
    }

    public Flight update(Flight flight) {
        return flightPersistenceManager.save(flight);
    }

    public void delete(UUID id){
        flightPersistenceManager.delete(id);
    }

}
