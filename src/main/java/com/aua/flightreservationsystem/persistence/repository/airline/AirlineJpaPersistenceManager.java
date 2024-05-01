package com.aua.flightreservationsystem.persistence.repository.airline;

import com.aua.flightreservationsystem.core.airline.Airline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AirlineJpaPersistenceManager implements AirlinePersistenceManager {
    private final AirlineRepository airlineRepository;
    private final AirlineEntityMapper airlineEntityMapper;

    @Autowired
    public AirlineJpaPersistenceManager(AirlineRepository airlineRepository, AirlineEntityMapper airlineEntityMapper) {
        this.airlineRepository = airlineRepository;
        this.airlineEntityMapper = airlineEntityMapper;
    }

    @Override
    public List<Airline> findAllAirlines() {
        return airlineRepository.findAll().stream().map(airlineEntityMapper::map).toList();
    }

    @Override
    public Optional<Airline> findAirlineById(UUID id) {
        return airlineRepository.findById(id).map(airlineEntityMapper::map);
    }

    @Override
    public Airline saveAirline(Airline airline) {
        return airlineEntityMapper.map(airlineRepository.save(airlineEntityMapper.map(airline)));
    }

    @Override
    public void deleteAirline(UUID id) {
        airlineRepository.deleteById(id);
    }
}
