package com.aua.flightreservationsystem.core.flight;

import com.aua.flightreservationsystem.api.flight.FlightRequest;
import com.aua.flightreservationsystem.core.city.City;
import com.aua.flightreservationsystem.core.flight.exceptions.FlightAlreadyExistsException;
import com.aua.flightreservationsystem.persistence.repository.city.CityPersistenceManager;
import com.aua.flightreservationsystem.persistence.repository.flight.FlightPersistenceManager;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FlightService {
    private final FlightPersistenceManager flightPersistenceManager;
    private final CityPersistenceManager cityPersistenceManager;

    public List<Flight> getAll() {
        return flightPersistenceManager.findAll();
    }

    public Optional<Flight> getById(UUID id) {
        return flightPersistenceManager.findById(id);
    }

    public Flight save(FlightRequest flightRequest) throws FlightAlreadyExistsException {

        Optional<City> destination = cityPersistenceManager.findById(flightRequest.getDestination());
        Optional<City> source = cityPersistenceManager.findById(flightRequest.getSource());

        if (destination.isEmpty()) {
            // TODO fix it once it is there
            throw new FlightAlreadyExistsException(flightRequest.getSource());
        }

        if (source.isEmpty()) {
            // TODO fix it once it is there
            throw new FlightAlreadyExistsException(flightRequest.getSource());
        }

        Flight newFlight = Flight.builder()
                .destination(destination.get())
                .source(source.get())
                .time(flightRequest.getDate())
                .build();

        return flightPersistenceManager.save(newFlight);
    }

    public Flight update(Flight flight) {
        return flightPersistenceManager.save(flight);
    }

    public void delete(UUID id) {
        flightPersistenceManager.delete(id);
    }
}
