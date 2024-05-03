package com.aua.flightreservationsystem.api.aircraft;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.UUID;


@Value
@Builder
@Jacksonized
public class AircraftResponse {
    UUID id;
    String modelName;
    Short numberOfSeats;
    UUID aircraftFactoryId;
}
