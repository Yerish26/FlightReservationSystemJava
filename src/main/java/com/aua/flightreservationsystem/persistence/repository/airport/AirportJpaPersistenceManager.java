package com.aua.flightreservationsystem.persistence.repository.airport;

import com.aua.flightreservationsystem.core.airport.Airport;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirportJpaPersistenceManager implements AirportPersistenceManager {
    private final AirportRepository airportRepository;
    private final AirportEntityMapper airportEntityMapper;

    @Autowired
    public AirportJpaPersistenceManager(AirportRepository airportRepository, AirportEntityMapper airportEntityMapper) {
        this.airportRepository = airportRepository;
        this.airportEntityMapper = airportEntityMapper;
    }

    @Override
    public List<Airport> findAll() {
        return airportRepository.findAll().stream()
                .map(airportEntityMapper::map)
                .toList();
    }

    @Override
    public Optional<Airport> findById(UUID id) {
        return airportRepository.findById(id).map(airportEntityMapper::map);
    }

    @Override
    public Airport save(Airport airport) {
        return airportEntityMapper.map(airportRepository.save(airportEntityMapper.map(airport)));
    }

    @Override
    public void delete(UUID id) {
        airportRepository.deleteById(id);
    }
}
