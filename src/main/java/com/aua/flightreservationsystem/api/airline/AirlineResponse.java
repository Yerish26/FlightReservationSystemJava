package com.aua.flightreservationsystem.api.airline;

import java.util.UUID;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class AirlineResponse {
    UUID id;
    String name;
}
