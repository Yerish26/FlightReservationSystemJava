package com.aua.flightreservationsystem.core.aircraftFactory;

import com.aua.flightreservationsystem.api.aircraftFactory.AircraftFactoryRequest;
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

    public AircraftFactory save(AircraftFactoryRequest aircraftFactoryRequest) {
        AircraftFactory aircraftFactory = getAircraftFactory(aircraftFactoryRequest);
        return aircraftFactoryPersistenceManager.save(aircraftFactory);
    }

    public AircraftFactory update(UUID id, AircraftFactoryRequest aircraftFactoryRequest) {
        Optional<AircraftFactory> aircraftFactoryOptional = aircraftFactoryPersistenceManager.findById(id);
        if (aircraftFactoryOptional.isEmpty()) {
            return save(aircraftFactoryRequest);
        }
        
        AircraftFactory aircraftFactory = getAircraftFactory(aircraftFactoryRequest).toBuilder().id(id).build();
        
        return aircraftFactoryPersistenceManager.save(aircraftFactory);
    }

    private static AircraftFactory getAircraftFactory(AircraftFactoryRequest aircraftFactoryRequest) {
        return AircraftFactory.builder()
                .modelName(aircraftFactoryRequest.getModelName())
                .build();
    }

    public void delete(UUID id){
        aircraftFactoryPersistenceManager.delete(id);
    }
}
