package com.aua.flightreservationsystem.api.aircraftFactory;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.List;
import java.util.UUID;

@Value
@Builder
@Jacksonized
public class AircraftFactoryRequest {
    String modelName;
//    List<UUID> aircraftIds;
}
