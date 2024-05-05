package com.aua.flightreservationsystem.api.airport;

import java.util.UUID;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class AirportRequest {
    String name;
    UUID city;
}
