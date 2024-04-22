package com.aua.flightreservationsystem.api.flight;

import com.aua.flightreservationsystem.core.flight.Flight;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FlightApiMapper {

    FlightResponse map(Flight flight);

    Flight map(FlightRequest flightRequest);

    Flight map(Long flightId, FlightRequest flightRequest);
}
