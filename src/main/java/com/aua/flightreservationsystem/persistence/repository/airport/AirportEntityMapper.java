package com.aua.flightreservationsystem.persistence.repository.airport;

import com.aua.flightreservationsystem.core.airport.Airport;
import com.aua.flightreservationsystem.persistence.model.AirportEntity;
import com.aua.flightreservationsystem.persistence.model.CityEntity;
import org.springframework.stereotype.Component;

@Component
public class AirportEntityMapper {
    public Airport map(AirportEntity airportEntity) {
        return Airport.builder()
                .id(airportEntity.getId())
                .cityId(airportEntity.getCity().getId())
                .build();
    }
    public AirportEntity map(Airport airport) {
        AirportEntity airportEntity = new AirportEntity();
        airportEntity.setId(airport.getId());

        CityEntity cityEntity = new CityEntity();
        cityEntity.setId(airport.getCityId());
        airportEntity.setCity(cityEntity);

        return airportEntity;
    }
}
