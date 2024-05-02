package com.aua.flightreservationsystem.core.aircraftFactory;

import com.aua.flightreservationsystem.core.aircraftFactory.exceptions.AircraftFactoryAlreadyExistsException;
import com.aua.flightreservationsystem.persistence.repository.aircraftFactory.AircraftFactoryPersistenceManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AircraftFactoryService {
    private final AircraftFactoryPersistenceManager aircraftFactoryPersistenceManager;

    public List<AircraftFactory> getAll() {
        return aircraftFactoryPersistenceManager.findAll();
    }

    public Optional<AircraftFactory> getById(UUID id) {
        return aircraftFactoryPersistenceManager.findById(id);
    }

    public AircraftFactory save(AircraftFactory aircraftFactory) throws AircraftFactoryAlreadyExistsException {
        UUID id = aircraftFactory.getId();
        if (id != null && aircraftFactoryPersistenceManager.findById(id).isPresent()) {
            throw new AircraftFactoryAlreadyExistsException(id);
        }
        return aircraftFactoryPersistenceManager.save(aircraftFactory);
    }

    public AircraftFactory update(AircraftFactory aircraftFactory) {
        return aircraftFactoryPersistenceManager.save(aircraftFactory);
    }

    public void delete(UUID id){
        aircraftFactoryPersistenceManager.delete(id);
    }
}
