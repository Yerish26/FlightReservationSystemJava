package com.aua.flightreservationsystem.persistence.repository.airline;
import com.aua.flightreservationsystem.core.airline.Airline;
import com.aua.flightreservationsystem.persistence.model.AirlineEntity;
import com.aua.flightreservationsystem.persistence.repository.flight.FlightEntityMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class AirlineEntityMapper {
    public AirlineEntityMapper(FlightEntityMapper flightEntityMapper) {
        this.flightEntityMapper = flightEntityMapper;
    }

    private final FlightEntityMapper flightEntityMapper;
    public Airline map(AirlineEntity airlineEntity) {
        return Airline.builder()
                .id(airlineEntity.getId())
                .name(airlineEntity.getName())
                .flights(airlineEntity.getFlights().stream().map(flightEntityMapper::map).toList())
                .build();
    }
    public AirlineEntity map(Airline airline) {
        AirlineEntity airlineEntity = new AirlineEntity();
        airlineEntity.setId(airline.getId());
        airlineEntity.setName(airline.getName());
        airlineEntity.setFlights(airline.getFlights().stream().map(flightEntityMapper::map).toList());
        return airlineEntity;
    }
}
