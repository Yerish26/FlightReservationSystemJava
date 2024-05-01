package com.aua.flightreservationsystem.persistence.repository.airport;

import com.aua.flightreservationsystem.core.airport.Airport;
import com.aua.flightreservationsystem.persistence.model.AirportEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AirportEntityMapper {
    Airport map(AirportEntity airportEntity);
    AirportEntity map(Airport airport);
}
