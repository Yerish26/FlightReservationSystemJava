package com.aua.flightreservationsystem.api.aircraftFactory;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.UUID;


@Value
@Builder
@Jacksonized
public class AircraftFactoryResponse {
    UUID id;
    String modelName;
}
