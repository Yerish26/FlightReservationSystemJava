package com.aua.flightreservationsystem.core.aircraftFactory;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder(toBuilder = true)
public class AircraftFactory {
    UUID id;
    String modelName;
}
