package com.aua.flightreservationsystem.api.aircraftFactory;

import com.aua.flightreservationsystem.core.aircraft.Aircraft;
import com.aua.flightreservationsystem.core.aircraftFactory.AircraftFactory;
import com.aua.flightreservationsystem.core.airline.Airline;
import com.aua.flightreservationsystem.core.flight.Flight;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface AircraftFactoryApiMapper {
    AircraftFactoryResponse map(AircraftFactory aircraftFactory);

    List<Aircraft> map(List<UUID> aircraftIds);

    Aircraft map(UUID aircraftId);

    AircraftFactory map(AircraftFactoryRequest aircraftFactoryRequest);

    AircraftFactory map(UUID id, AircraftFactoryRequest aircraftFactoryRequest);
}
