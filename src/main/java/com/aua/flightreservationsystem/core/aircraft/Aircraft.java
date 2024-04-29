package com.aua.flightreservationsystem.core.aircraft;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder(toBuilder = true)
public class Aircraft {
    UUID id;
    String modelName;
    Short numberOfSeats;
    UUID aircraftFactoryId;
}
