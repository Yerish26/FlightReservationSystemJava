package com.aua.flightreservationsystem.persistence.repository.aircraft;

import com.aua.flightreservationsystem.core.aircraft.Aircraft;
import com.aua.flightreservationsystem.persistence.model.AircraftEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AircraftEntityMapper {
    Aircraft map(AircraftEntity aircraftEntity);

    AircraftEntity map(Aircraft aircraft);
}
