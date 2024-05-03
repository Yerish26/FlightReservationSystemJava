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
        Optional<AircraftFactory> aircraftFactory = aircraftFactoryPersistenceManager.findById(aircraftRequest.getAircraftFactoryId());

        if (aircraftFactory.isEmpty()) {
            throw new AircraftFactoryNotFoundException(aircraftRequest.getAircraftFactoryId());
        }

        Aircraft aircraft = Aircraft.builder()
                .aircraftFactory(aircraftFactory.get())
                .modelName(aircraftRequest.getModelName())
                .numberOfSeats(aircraftRequest.getNumberOfSeats())
                .build();

        return aircraftPersistenceManager.save(aircraft);
    }

    public Aircraft update(UUID id, AircraftRequest aircraftRequest) throws AircraftAlreadyExistsException, AircraftFactoryNotFoundException {
        Optional<Aircraft> existingAircraftOptional = aircraftPersistenceManager.findById(id);
        Optional<AircraftFactory> aircraftFactory = aircraftFactoryPersistenceManager.findById(aircraftRequest.getAircraftFactoryId());

        if (aircraftFactory.isEmpty()) {
            throw new AircraftFactoryNotFoundException(aircraftRequest.getAircraftFactoryId());
        }

        if (existingAircraftOptional.isPresent()) {
            Aircraft existingAircraft = existingAircraftOptional.get();

            Aircraft updatedAircraft = Aircraft.builder()
                    .id(existingAircraft.getId())
                    .aircraftFactory(aircraftFactory.get())
                    .modelName(aircraftRequest.getModelName())
                    .numberOfSeats(aircraftRequest.getNumberOfSeats())
                    .build();

           return aircraftPersistenceManager.save(updatedAircraft);
        }

        return save(aircraftRequest);
    }

    public void delete(UUID id) {
        aircraftPersistenceManager.delete(id);
    }

}
