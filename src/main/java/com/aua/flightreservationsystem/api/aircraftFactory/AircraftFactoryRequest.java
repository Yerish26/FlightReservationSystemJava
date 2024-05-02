package com.aua.flightreservationsystem.api.aircraftFactory;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class AircraftFactoryRequest {
    String modelName;
}
