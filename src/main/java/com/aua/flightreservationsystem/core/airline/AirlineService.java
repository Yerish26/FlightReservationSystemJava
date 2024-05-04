package com.aua.flightreservationsystem.core.airline;

import com.aua.flightreservationsystem.core.airline.exceptions.AirlineAlreadyExistsException;
import com.aua.flightreservationsystem.persistence.repository.airline.AirlinePersistenceManager;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirlineService {
    private final AirlinePersistenceManager airlinePersistenceManager;

    @Autowired
    public AirlineService(AirlinePersistenceManager airlinePersistenceManager) {
        this.airlinePersistenceManager = airlinePersistenceManager;
    }

    public List<Airline> getAll() {
        return airlinePersistenceManager.findAll();
    }

    public Optional<Airline> getById(UUID id) {
        return airlinePersistenceManager.findById(id);
    }

    public Airline save(Airline airline) throws AirlineAlreadyExistsException {
        if (airlinePersistenceManager.findById(airline.getId()).isPresent()) {
            throw new AirlineAlreadyExistsException(airline.getId());
        }
        return airlinePersistenceManager.save(airline);
    }

    public Airline update(Airline airline) {
        return airlinePersistenceManager.save(airline);
    }

    public void delete(UUID id) {
        airlinePersistenceManager.delete(id);
    }
}
