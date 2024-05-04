package com.aua.flightreservationsystem.api.airline;

import java.util.List;
import java.util.UUID;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class AirlineRequest {
    String name;
    List<UUID> flightIds;
}
