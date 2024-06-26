package com.aua.flightreservationsystem.persistence.repository.aircraftFactory;

import com.aua.flightreservationsystem.core.aircraftFactory.AircraftFactory;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AircraftFactoryJpaPersistenceManager implements AircraftFactoryPersistenceManager {
    private final AircraftFactoryRepository aircraftFactoryRepository;
    private final AircraftFactoryEntityMapper aircraftFactoryEntityMapper;

    @Autowired
    public AircraftFactoryJpaPersistenceManager(
            AircraftFactoryRepository aircraftFactoryRepository,
            AircraftFactoryEntityMapper aircraftFactoryEntityMapper) {
        this.aircraftFactoryRepository = aircraftFactoryRepository;
        this.aircraftFactoryEntityMapper = aircraftFactoryEntityMapper;
    }

    @Override
    public List<AircraftFactory> findAll() {
        return aircraftFactoryRepository.findAll().stream()
                .map(aircraftFactoryEntityMapper::map)
                .toList();
    }

    @Override
    public Optional<AircraftFactory> findById(UUID id) {
        return aircraftFactoryRepository.findById(id).map(aircraftFactoryEntityMapper::map);
    }

    @Override
    public AircraftFactory save(AircraftFactory aircraftFactory) {
        return aircraftFactoryEntityMapper.map(
                aircraftFactoryRepository.save(aircraftFactoryEntityMapper.map(aircraftFactory)));
    }

    @Override
    public void delete(UUID id) {
        aircraftFactoryRepository.deleteById(id);
    }
}
