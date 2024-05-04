package com.aua.flightreservationsystem.persistence.repository.flight;

import com.aua.flightreservationsystem.core.flight.Flight;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightJpaPersistenceManager implements FlightPersistenceManager {

    private final FlightRepository flightRepository;

    private final FlightEntityMapper flightEntityMapper;

    @Autowired
    public FlightJpaPersistenceManager(FlightRepository flightRepository, FlightEntityMapper flightEntityMapper) {
        this.flightRepository = flightRepository;
        this.flightEntityMapper = flightEntityMapper;
    }

    @Override
    public List<Flight> findAll() {
        return flightRepository.findAll().stream().map(flightEntityMapper::map).toList();
    }

    @Override
    public Optional<Flight> findById(UUID id) {
        return flightRepository.findById(id).map(flightEntityMapper::map);
    }

    @Override
    public Flight save(Flight flight) {
        return flightEntityMapper.map(flightRepository.save(flightEntityMapper.map(flight)));
    }

    @Override
    public void delete(UUID id) {
        flightRepository.deleteById(id);
    }
}
