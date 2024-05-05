package com.aua.flightreservationsystem.api.city;

import java.util.UUID;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class CityResponse {
    UUID id;
    String name;
}
