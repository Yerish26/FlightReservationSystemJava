package com.aua.flightreservationsystem.api.flight;

import com.aua.flightreservationsystem.core.city.City;
import com.aua.flightreservationsystem.core.flight.Flight;
import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface FlightApiMapper {

    FlightResponse map(Flight flight);

    City map(UUID id);

    Flight map(FlightRequest flightRequest);

    Flight map(UUID id, FlightRequest flightRequest);
}
