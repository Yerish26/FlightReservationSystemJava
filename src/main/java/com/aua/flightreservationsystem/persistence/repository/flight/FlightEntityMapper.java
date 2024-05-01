package com.aua.flightreservationsystem.persistence.repository.flight;

import com.aua.flightreservationsystem.core.flight.Flight;
import com.aua.flightreservationsystem.persistence.model.FlightEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FlightEntityMapper {
    Flight map(FlightEntity flightEntity);
    FlightEntity map(Flight flight);
}
