package com.aua.flightreservationsystem.persistence.repository.aircraft;

import com.aua.flightreservationsystem.core.aircraft.Aircraft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AircraftJpaPersistenceManager implements AircraftPersistenceManager {
    private final AircraftRepository aircraftRepository;
    private final AircraftEntityMapper aircraftEntityMapper;

    @Autowired
    public AircraftJpaPersistenceManager(AircraftRepository aircraftRepository, AircraftEntityMapper aircraftEntityMapper) {
        this.aircraftRepository = aircraftRepository;
        this.aircraftEntityMapper = aircraftEntityMapper;
    }

    @Override
    public List<Aircraft> findAllAircrafts() {
        return aircraftRepository.findAll().stream().map(aircraftEntityMapper::map).toList();
    }

    @Override
    public Optional<Aircraft> findAircraftById(UUID id) {
        return aircraftRepository.findById(id).map(aircraftEntityMapper::map);
    }

    @Override
    public Aircraft saveAircraft(Aircraft aircraft) {
        return aircraftEntityMapper.map(aircraftRepository.save(aircraftEntityMapper.map(aircraft)));
    }

    @Override
    public void deleteAircraft(UUID id) {
        aircraftRepository.deleteById(id);
    }
}