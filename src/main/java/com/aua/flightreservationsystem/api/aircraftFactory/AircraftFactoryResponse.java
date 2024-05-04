package com.aua.flightreservationsystem.api.aircraftFactory;

import java.util.UUID;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class AircraftFactoryResponse {
    UUID id;
    String modelName;
}
