package com.aua.flightreservationsystem.api.airline;

import com.aua.flightreservationsystem.core.airline.Airline;
import com.aua.flightreservationsystem.core.flight.Flight;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface AirlineApiMapper {
    AirlineResponse map(Airline airline);

    List<Flight> map(List<UUID> flightsIds);

    Airline map(AirlineRequest airlineRequest);

    Airline map(UUID id, AirlineRequest airlineRequest);
}
