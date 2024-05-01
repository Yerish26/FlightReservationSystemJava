package com.aua.flightreservationsystem.api.airline;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.UUID;


@Value
@Builder
@Jacksonized
public class AirlineResponse {
    UUID id;
    String name;
}
