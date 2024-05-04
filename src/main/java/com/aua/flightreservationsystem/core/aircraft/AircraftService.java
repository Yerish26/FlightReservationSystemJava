package com.aua.flightreservationsystem.core.aircraft;

import com.aua.flightreservationsystem.api.aircraft.AircraftRequest;
import com.aua.flightreservationsystem.core.aircraft.exceptions.AircraftAlreadyExistsException;
import com.aua.flightreservationsystem.core.aircraftFactory.AircraftFactory;
import com.aua.flightreservationsystem.core.aircraftFactory.exceptions.AircraftFactoryNotFoundException;
import com.aua.flightreservationsystem.persistence.repository.aircraft.AircraftPersistenceManager;
import com.aua.flightreservationsystem.persistence.repository.aircraftFactory.AircraftFactoryPersistenceManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class AircraftService {
    private final AircraftPersistenceManager aircraftPersistenceManager;
    private final AircraftFactoryPersistenceManager aircraftFactoryPersistenceManager;

    public List<Aircraft> getAll() {
        return aircraftPersistenceManager.findAll();
    }

    public Optional<Aircraft> getById(UUID id) {
        return aircraftPersistenceManager.findById(id);
    }

    public Aircraft save(AircraftRequest aircraftRequest) throws AircraftAlreadyExistsException, AircraftFactoryNotFoundException {
        Optional<AircraftFactory> aircraftFactory = getAircraftFactory(aircraftRequest);

        Aircraft aircraft = getAircraft(aircraftRequest, aircraftFactory);

        return aircraftPersistenceManager.save(aircraft);
    }

    private static Aircraft getAircraft(AircraftRequest aircraftRequest, Optional<AircraftFactory> aircraftFactory) {
        return Aircraft.builder()
                .aircraftFactory(aircraftFactory.get())
                .modelName(aircraftRequest.getModelName())
                .numberOfSeats(aircraftRequest.getNumberOfSeats())
                .build();
    }

    public Aircraft update(UUID id, AircraftRequest aircraftRequest) throws AircraftAlreadyExistsException, AircraftFactoryNotFoundException {
        Optional<AircraftFactory> aircraftFactory = getAircraftFactory(aircraftRequest);
        Optional<Aircraft> existingAircraftOptional = aircraftPersistenceManager.findById(id);

        if (existingAircraftOptional.isPresent()) {
            Aircraft existingAircraft = existingAircraftOptional.get();
            Aircraft updatedAircraft = getAircraft(aircraftRequest, aircraftFactory).toBuilder().id(existingAircraft.getId()).build();
           return aircraftPersistenceManager.save(updatedAircraft);
        }
        return save(aircraftRequest);
    }

    private Optional<AircraftFactory> getAircraftFactory(AircraftRequest aircraftRequest) throws AircraftFactoryNotFoundException {
        Optional<AircraftFactory> aircraftFactory = aircraftFactoryPersistenceManager.findById(aircraftRequest.getAircraftFactoryId());

        if (aircraftFactory.isEmpty()) {
            throw new AircraftFactoryNotFoundException(aircraftRequest.getAircraftFactoryId());
        }
        return aircraftFactory;
    }

    public void delete(UUID id) {
        aircraftPersistenceManager.delete(id);
    }

}
