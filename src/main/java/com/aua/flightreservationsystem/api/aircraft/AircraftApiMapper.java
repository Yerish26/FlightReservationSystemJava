package com.aua.flightreservationsystem.api.aircraft;

import com.aua.flightreservationsystem.core.aircraft.Aircraft;
import com.aua.flightreservationsystem.core.aircraftFactory.AircraftFactory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface AircraftApiMapper {
    AircraftResponse map(Aircraft aircraft);

    List<Aircraft> map(List<UUID> aircraftIds);

    Aircraft map(UUID aircraftId);

//    @Mapping(target = "aircraftFactory", source = "aircraftFactoryId", qualifiedByName = "uuidToAircraftFactory")
    Aircraft map(AircraftRequest aircraftRequest);

    Aircraft map(UUID id, AircraftRequest aircraftRequest);
}
