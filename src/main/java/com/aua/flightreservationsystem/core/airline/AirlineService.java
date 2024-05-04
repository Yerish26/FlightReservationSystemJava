package com.aua.flightreservationsystem.core.airline;

import com.aua.flightreservationsystem.api.airline.AirlineRequest;
import com.aua.flightreservationsystem.core.flight.Flight;
import com.aua.flightreservationsystem.core.flight.exceptions.OneOrMoreFlightsNotFoundException;
import com.aua.flightreservationsystem.persistence.repository.airline.AirlinePersistenceManager;
import com.aua.flightreservationsystem.persistence.repository.flight.FlightPersistenceManager;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AirlineService {
    private final AirlinePersistenceManager airlinePersistenceManager;
    private final FlightPersistenceManager flightPersistenceManager;

    public List<Airline> getAll() {
        return airlinePersistenceManager.findAll();
    }

    public Optional<Airline> getById(UUID id) {
        return airlinePersistenceManager.findById(id);
    }

    public Airline save(AirlineRequest airlineRequest) throws OneOrMoreFlightsNotFoundException {

        List<Flight> flights = getFlights(airlineRequest);

        Airline airline = getAirline(airlineRequest, flights);
        return airlinePersistenceManager.save(airline);
    }

    private static Airline getAirline(AirlineRequest airlineRequest, List<Flight> flights) {
        return Airline.builder().name(airlineRequest.getName()).flights(flights).build();
    }

    private List<Flight> getFlights(AirlineRequest airlineRequest) throws OneOrMoreFlightsNotFoundException {
        List<Flight> flights = flightPersistenceManager.findAllById(airlineRequest.getFlightIds());

        if (flights.size() != airlineRequest.getFlightIds().size()) {
            throw new OneOrMoreFlightsNotFoundException("One or more flights were not found.");
        }
        return flights;
    }

    public Airline update(UUID id, AirlineRequest airlineRequest) throws OneOrMoreFlightsNotFoundException {
        List<Flight> flights = getFlights(airlineRequest);

        Optional<Airline> existingAirlineOptional = airlinePersistenceManager.findById(id);

        if (existingAirlineOptional.isPresent()) {
            Airline existingAirline = existingAirlineOptional.get();
            Airline updatedAirline = getAirline(airlineRequest, flights).toBuilder()
                    .id(existingAirline.getId())
                    .build();
            return airlinePersistenceManager.save(updatedAirline);
        }
        return save(airlineRequest);
    }

    public void delete(UUID id) {
        airlinePersistenceManager.delete(id);
    }
}
