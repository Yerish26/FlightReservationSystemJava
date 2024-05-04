package com.aua.flightreservationsystem.api.aircraft;

import java.util.UUID;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class AircraftResponse {
    UUID id;
    String modelName;
    Short numberOfSeats;
    UUID aircraftFactoryId;
}
