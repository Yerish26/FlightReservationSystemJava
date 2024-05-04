package com.aua.flightreservationsystem.api.airline;

import com.aua.flightreservationsystem.core.airline.Airline;
import com.aua.flightreservationsystem.core.flight.Flight;
import java.util.List;
import java.util.UUID;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AirlineApiMapper {
    AirlineResponse map(Airline airline);

    List<Flight> map(List<UUID> flightsIds);

    Flight map(UUID flightsId);

    Airline map(AirlineRequest airlineRequest);

    Airline map(UUID id, AirlineRequest airlineRequest);
}
