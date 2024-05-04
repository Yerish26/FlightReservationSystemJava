package com.aua.flightreservationsystem.persistence.repository.aircraftFactory;

import com.aua.flightreservationsystem.core.aircraftFactory.AircraftFactory;
import com.aua.flightreservationsystem.persistence.model.AircraftFactoryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AircraftFactoryEntityMapper {
    AircraftFactory map(AircraftFactoryEntity aircraftFactoryEntity);

    AircraftFactoryEntity map(AircraftFactory aircraftFactory);
}
