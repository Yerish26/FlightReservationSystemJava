package com.aua.flightreservationsystem.api.country;

import java.util.UUID;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class CountryResponse {
    UUID id;
    String name;
}
