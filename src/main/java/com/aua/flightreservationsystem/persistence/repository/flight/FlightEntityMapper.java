package com.aua.flightreservationsystem.persistence.repository.flight;

import com.aua.flightreservationsystem.core.flight.Flight;
import com.aua.flightreservationsystem.persistence.model.FlightEntity;
import org.springframework.stereotype.Component;

@Component
public class FlightEntityMapper {
    public Flight map(FlightEntity flightEntity) {
        return Flight.builder()
                .flightId(flightEntity.getFlightId())
                .source(flightEntity.getSource())
                .destination(flightEntity.getDestination())
                .date(flightEntity.getDate())
                .build();
    }

    public FlightEntity map(Flight flight) {
        FlightEntity flightEntity = new FlightEntity();
        flightEntity.setFlightId(flight.getFlightId());
        flightEntity.setSource(flight.getSource());
        flightEntity.setDestination(flight.getDestination());
        flightEntity.setDate(flight.getDate());
        return flightEntity;
    }
}
