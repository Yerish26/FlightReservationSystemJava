package com.aua.flightreservationsystem.persistence.repository.city;

import com.aua.flightreservationsystem.core.city.City;
import com.aua.flightreservationsystem.persistence.model.CityEntity;
import com.aua.flightreservationsystem.persistence.repository.airport.AirportEntityMapper;
import com.aua.flightreservationsystem.persistence.repository.country.CountryEntityMapper;
import com.aua.flightreservationsystem.persistence.repository.flight.FlightEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class CityEntityMapper {
    private final CountryEntityMapper countryEntityMapper;
    private final AirportEntityMapper airportEntityMapper;
    private final FlightEntityMapper flightEntityMapper;

    public CityEntityMapper(CountryEntityMapper countryEntityMapper, AirportEntityMapper airportEntityMapper, FlightEntityMapper flightEntityMapper) {
        this.countryEntityMapper = countryEntityMapper;
        this.airportEntityMapper = airportEntityMapper;
        this.flightEntityMapper = flightEntityMapper;
    }

    public City map(CityEntity cityEntity) {
        return City.builder()
                .id(cityEntity.getId())
                .name(cityEntity.getName())
                .country(countryEntityMapper.map(cityEntity.getCountry()))
                .airport(airportEntityMapper.map(cityEntity.getAirport()))
                .flights(cityEntity.getFlights().stream().map(flightEntityMapper::map).toList())
                .build();
    }

    public CityEntity map(City city) {
        CityEntity cityEntity = new CityEntity();
        cityEntity.setId(city.getId());
        cityEntity.setName(city.getName());
        cityEntity.setCountry(countryEntityMapper.map(city.getCountry()));
        cityEntity.setAirport(airportEntityMapper.map(city.getAirport()));
        cityEntity.setFlights(city.getFlights().stream().map(flightEntityMapper::map).toList());
        return cityEntity;
    }
}
