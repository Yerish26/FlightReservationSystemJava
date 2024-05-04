package com.aua.flightreservationsystem.persistence.repository.airline;

import com.aua.flightreservationsystem.core.airline.Airline;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<Airline> findAll() {
        return airlineRepository.findAll().stream()
                .map(airlineEntityMapper::map)
                .toList();
    }

    @Override
    public Optional<Airline> findById(UUID id) {
        return airlineRepository.findById(id).map(airlineEntityMapper::map);
    }

    @Override
    public Airline save(Airline airline) {
        return airlineEntityMapper.map(airlineRepository.save(airlineEntityMapper.map(airline)));
    }

    @Override
    public void delete(UUID id) {
        airlineRepository.deleteById(id);
    }
}
