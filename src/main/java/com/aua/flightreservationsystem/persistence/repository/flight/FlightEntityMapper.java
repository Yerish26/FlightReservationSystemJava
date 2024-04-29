package com.aua.flightreservationsystem.persistence.repository.flight;

import com.aua.flightreservationsystem.core.flight.Flight;
import com.aua.flightreservationsystem.persistence.model.FlightEntity;
import com.aua.flightreservationsystem.persistence.repository.city.CityEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class FlightEntityMapper {
    private final CityEntityMapper cityMapperEntity;

    public FlightEntityMapper(CityEntityMapper cityMapperEntity) {
        this.cityMapperEntity = cityMapperEntity;
    }

    public Flight map(FlightEntity flightEntity) {
        return Flight.builder()
                .id(flightEntity.getId())
                .source(cityMapperEntity.map(flightEntity.getSource()))
                .destination(cityMapperEntity.map(flightEntity.getDestination()))
                .time(flightEntity.getTime())
                .build();
    }

    public FlightEntity map(Flight flight) {
        FlightEntity flightEntity = new FlightEntity();
        flightEntity.setId(flight.getId());
        flightEntity.setSource(cityMapperEntity.map(flight.getSource()));
        flightEntity.setDestination(cityMapperEntity.map(flight.getDestination()));
        flightEntity.setTime(flight.getTime());
        return flightEntity;
    }
}
