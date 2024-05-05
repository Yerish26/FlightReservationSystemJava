package com.aua.flightreservationsystem.core.airport;

import com.aua.flightreservationsystem.api.airport.AirportRequest;
import com.aua.flightreservationsystem.core.city.City;
import com.aua.flightreservationsystem.core.city.exceptions.CityNotFoundException;
import com.aua.flightreservationsystem.persistence.repository.airport.AirportPersistenceManager;
import com.aua.flightreservationsystem.persistence.repository.city.CityPersistenceManager;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AirportService {
    private final AirportPersistenceManager airportPersistenceManager;
    private final CityPersistenceManager cityPersistenceManager;

    public List<Airport> getAll() {
        return airportPersistenceManager.findAll();
    }

    public Optional<Airport> getById(UUID id) {
        return airportPersistenceManager.findById(id);
    }

    public Airport save(AirportRequest airportRequest) throws CityNotFoundException {
        // TODO remove the comment out code and replace null with city in line 32
        //        City city = getCity(airportRequest);
        Airport airport = getAirport(airportRequest, null);
        return airportPersistenceManager.save(airport);
    }

    public Airport update(UUID id, AirportRequest airportRequest) throws CityNotFoundException {
        Optional<Airport> airportOptional = airportPersistenceManager.findById(id);
        if (airportOptional.isEmpty()) {
            return save(airportRequest);
        }
        // TODO remove the comment out code and replace null with city in line 44
        //        City city = getCity(airportRequest);
        Airport airport = getAirport(airportRequest, null).toBuilder().id(id).build();

        return airportPersistenceManager.save(airport);
    }

    private City getCity(AirportRequest airportRequest) throws CityNotFoundException {
        Optional<City> optionalCity = cityPersistenceManager.findById(airportRequest.getCity());
        if (optionalCity.isEmpty()) {
            throw new CityNotFoundException(airportRequest.getCity());
        }
        return optionalCity.get();
    }

    private static Airport getAirport(AirportRequest airportRequest, City city) {
        return Airport.builder().name(airportRequest.getName()).city(city).build();
    }

    public void delete(UUID id) {
        airportPersistenceManager.delete(id);
    }
}
