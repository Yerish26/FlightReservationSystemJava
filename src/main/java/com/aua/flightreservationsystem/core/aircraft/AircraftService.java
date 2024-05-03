package com.aua.flightreservationsystem.core.aircraft;

import com.aua.flightreservationsystem.core.aircraft.exceptions.AircraftAlreadyExistsException;
import com.aua.flightreservationsystem.persistence.repository.aircraft.AircraftPersistenceManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class AircraftService {
    private final AircraftPersistenceManager aircraftPersistenceManager;

    public List<Aircraft> getAll() {
        return aircraftPersistenceManager.findAll();
    }
    public Optional<Aircraft> getById(UUID id) {
        return aircraftPersistenceManager.findById(id);
    }

    public Aircraft save(Aircraft aircraft) throws AircraftAlreadyExistsException {
        UUID id = aircraft.getId();
        if (id != null && aircraftPersistenceManager.findById(id).isPresent()) {
            throw new AircraftAlreadyExistsException(id);
        }
        return aircraftPersistenceManager.save(aircraft);
    }

    public Aircraft update(Aircraft aircraft) {
        return aircraftPersistenceManager.save(aircraft);
    }

    public void delete(UUID id){
        aircraftPersistenceManager.delete(id);
    }

}
