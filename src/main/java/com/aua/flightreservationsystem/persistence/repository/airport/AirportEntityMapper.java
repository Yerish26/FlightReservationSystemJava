package com.aua.flightreservationsystem.persistence.repository.airport;

import com.aua.flightreservationsystem.core.airport.Airport;
import com.aua.flightreservationsystem.persistence.model.AirportEntity;
import com.aua.flightreservationsystem.persistence.model.CityEntity;
import com.aua.flightreservationsystem.persistence.repository.city.CityEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class AirportEntityMapper {
    private final CityEntityMapper cityEntityMapper;

    public AirportEntityMapper(CityEntityMapper cityEntityMapper) {
        this.cityEntityMapper = cityEntityMapper;
    }

    public Airport map(AirportEntity airportEntity) {
        return Airport.builder()
                .id(airportEntity.getId())
                .city(cityEntityMapper.map(airportEntity.getCity()))
                .build();
    }

    public AirportEntity map(Airport airport) {
        AirportEntity airportEntity = new AirportEntity();
        airportEntity.setId(airport.getId());
        airportEntity.setCity(cityEntityMapper.map(airport.getCity()));
        return airportEntity;
    }
}
