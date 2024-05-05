package com.aua.flightreservationsystem.api.airport;

import com.aua.flightreservationsystem.core.airport.Airport;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AirportApiMapper {
    AirportResponse map(Airport airport);
}
