package com.aua.flightreservationsystem.api.aircraft;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.UUID;

@Value
@Builder
@Jacksonized
public class AircraftRequest {
    String modelName;
    Short numberOfSeats;
    UUID aircraftFactoryId;
}
