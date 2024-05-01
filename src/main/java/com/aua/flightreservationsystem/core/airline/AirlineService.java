package com.aua.flightreservationsystem.core.airline;

import com.aua.flightreservationsystem.core.airline.exceptions.AirlineAlreadyExistsException;
import com.aua.flightreservationsystem.core.flight.exceptions.FlightAlreadyExistsException;
import com.aua.flightreservationsystem.persistence.repository.airline.AirlinePersistenceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AirlineService {
    private final AirlinePersistenceManager airlinePersistenceManager;

    @Autowired
    public AirlineService(AirlinePersistenceManager airlinePersistenceManager) {
        this.airlinePersistenceManager = airlinePersistenceManager;
    }

    public List<Airline> getAllAirlines() {
        return airlinePersistenceManager.findAllAirlines();
    }

    public Optional<Airline> getAirlineById(UUID id) {
        return airlinePersistenceManager.findAirlineById(id);
    }

    public Airline save(Airline airline) throws AirlineAlreadyExistsException {
        if(airlinePersistenceManager.findAirlineById(airline.getId()).isPresent()) {
            throw new AirlineAlreadyExistsException(airline.getId());
        }
        return airlinePersistenceManager.saveAirline(airline);
    }

    public Airline update(Airline airline) {
        return airlinePersistenceManager.saveAirline(airline);
    }

    public void delete(UUID id){
        airlinePersistenceManager.deleteAirline(id);
    }

}
