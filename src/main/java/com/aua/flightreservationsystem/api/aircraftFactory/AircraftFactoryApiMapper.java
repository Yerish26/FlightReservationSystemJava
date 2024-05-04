package com.aua.flightreservationsystem.api.aircraftFactory;

import com.aua.flightreservationsystem.core.aircraftFactory.AircraftFactory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AircraftFactoryApiMapper {
    AircraftFactoryResponse map(AircraftFactory aircraftFactory);
}
