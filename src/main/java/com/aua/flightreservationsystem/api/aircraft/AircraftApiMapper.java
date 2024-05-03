package com.aua.flightreservationsystem.api.aircraft;

import com.aua.flightreservationsystem.core.aircraft.Aircraft;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface AircraftApiMapper {

    @Mapping(target = "aircraftFactoryId", source = "aircraft.aircraftFactory.id")
    AircraftResponse map(Aircraft aircraft);

    Aircraft map(UUID id, AircraftRequest aircraftRequest);
}
