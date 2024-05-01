package com.aua.flightreservationsystem.api.airline;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.List;
import java.util.UUID;

@Value
@Builder
@Jacksonized
public class AirlineRequest {
    String name;
    List<UUID> flightIds;
}
