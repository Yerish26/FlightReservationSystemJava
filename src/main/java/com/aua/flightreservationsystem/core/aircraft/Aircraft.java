package com.aua.flightreservationsystem.core.aircraft;

import com.aua.flightreservationsystem.core.aircraftFactory.AircraftFactory;
import java.util.UUID;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class Aircraft {
    UUID id;
    String modelName;
    Short numberOfSeats;
    AircraftFactory aircraftFactory;
}
