package com.aua.flightreservationsystem.core.city;

import com.aua.flightreservationsystem.api.city.CityRequest;
import com.aua.flightreservationsystem.core.airport.Airport;
import com.aua.flightreservationsystem.core.airport.exceptions.AirportNotFoundException;
import com.aua.flightreservationsystem.core.country.Country;
import com.aua.flightreservationsystem.core.country.exceptions.CountryNotFoundException;
import com.aua.flightreservationsystem.core.flight.Flight;
import com.aua.flightreservationsystem.core.flight.exceptions.OneOrMoreFlightsNotFoundException;
import com.aua.flightreservationsystem.persistence.repository.airport.AirportPersistenceManager;
import com.aua.flightreservationsystem.persistence.repository.city.CityPersistenceManager;
import com.aua.flightreservationsystem.persistence.repository.country.CountryPersistenceManager;
import com.aua.flightreservationsystem.persistence.repository.flight.FlightPersistenceManager;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CityService {
    private final CityPersistenceManager cityPersistenceManager;
    private final FlightPersistenceManager flightPersistenceManager;
    private final AirportPersistenceManager airportPersistenceManager;
    private final CountryPersistenceManager countryPersistenceManager;

    public List<City> getAll() {
        return cityPersistenceManager.findAll();
    }

    public Optional<City> getById(UUID id) {
        return cityPersistenceManager.findById(id);
    }

    public City save(CityRequest cityRequest)
            throws OneOrMoreFlightsNotFoundException, CountryNotFoundException, AirportNotFoundException {

        // TODO remove this
        if (cityRequest.getFlightIds().isEmpty()) {
            return cityPersistenceManager.save(getCity(cityRequest, null, null, null));
        }
        List<Flight> flights = getFlights(cityRequest);

        Country country = getCountry(cityRequest);
        Airport airport = getAirport(cityRequest);

        City city = getCity(cityRequest, flights, country, airport);
        return cityPersistenceManager.save(city);
    }

    private Airport getAirport(CityRequest cityRequest) throws AirportNotFoundException {
        Optional<Airport> airport = airportPersistenceManager.findById(cityRequest.getAirport());
        if (airport.isEmpty()) {
            throw new AirportNotFoundException(cityRequest.getAirport());
        }
        return airport.get();
    }

    private Country getCountry(CityRequest cityRequest) throws CountryNotFoundException {
        Optional<Country> country = countryPersistenceManager.findById(cityRequest.getCountry());
        if (country.isEmpty()) {
            throw new CountryNotFoundException(cityRequest.getCountry());
        }
        return country.get();
    }

    private static City getCity(CityRequest cityRequest, List<Flight> flights, Country country, Airport airport) {
        return City.builder()
                .name(cityRequest.getName())
                .flights(flights)
                .country(country)
                .airport(airport)
                .build();
    }

    private List<Flight> getFlights(CityRequest cityRequest) throws OneOrMoreFlightsNotFoundException {
        List<Flight> flights = flightPersistenceManager.findAllById(cityRequest.getFlightIds());

        if (flights.size() != cityRequest.getFlightIds().size()) {
            throw new OneOrMoreFlightsNotFoundException("One or more flights were not found.");
        }
        return flights;
    }

    public City update(UUID id, CityRequest cityRequest)
            throws OneOrMoreFlightsNotFoundException, CountryNotFoundException, AirportNotFoundException {
        // TODO remove this
        if (cityRequest.getFlightIds().isEmpty()) {
            return save(cityRequest);
        }
        List<Flight> flights = getFlights(cityRequest);

        Country country = getCountry(cityRequest);
        Airport airport = getAirport(cityRequest);

        Optional<City> existingCityOptional = cityPersistenceManager.findById(id);

        if (existingCityOptional.isPresent()) {
            City updatedCity = getCity(cityRequest, flights, country, airport).toBuilder()
                    .id(id)
                    .build();
            return cityPersistenceManager.save(updatedCity);
        }
        return save(cityRequest);
    }

    public void delete(UUID id) {
        cityPersistenceManager.delete(id);
    }
}
