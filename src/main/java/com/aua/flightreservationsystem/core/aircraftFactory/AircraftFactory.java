package com.aua.flightreservationsystem.core.aircraftFactory;

import com.aua.flightreservationsystem.core.aircraft.Aircraft;
import lombok.Builder;
import lombok.Value;

import java.util.List;
import java.util.UUID;

@Value
@Builder(toBuilder = true)
public class AircraftFactory {
    UUID id;
    String modelName;
    List<Aircraft> aircraft;
}
