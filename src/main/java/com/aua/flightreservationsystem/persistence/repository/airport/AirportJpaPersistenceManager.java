package com.aua.flightreservationsystem.persistence.repository.airport;

import com.aua.flightreservationsystem.core.airport.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
    public List<Airport> findAllAirports() {
        return airportRepository.findAll().stream().map(airportEntityMapper::map).toList();
    }

    @Override
    public Optional<Airport> findAirportById(UUID id) {
        return airportRepository.findById(id).map(airportEntityMapper::map);
    }

    @Override
    public Airport saveAirport(Airport airport) {
        return airportEntityMapper.map(airportRepository.save(airportEntityMapper.map(airport)));
    }

    @Override
    public void deleteAirport(UUID id) {
        airportRepository.deleteById(id);
    }
}