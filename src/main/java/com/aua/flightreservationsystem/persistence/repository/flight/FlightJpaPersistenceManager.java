package com.aua.flightreservationsystem.persistence.repository.flight;

import com.aua.flightreservationsystem.core.flight.Flight;
import com.aua.flightreservationsystem.core.flight.FlightPersistenceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public List<Flight> findAllFlights() {
        return flightRepository.findAll().stream().map(flightEntityMapper::map).toList();
    }

    @Override
    public Optional<Flight> findById(Long id) {
        return flightRepository.findById(id).map(flightEntityMapper::map);
    }

    @Override
    public Flight saveFlight(Flight flight) {
        return flightEntityMapper.map(flightRepository.save(flightEntityMapper.map(flight)));
    }

    @Override
    public void deleteFlight(Long flightId) {
        flightRepository.deleteById(flightId);
    }


}
