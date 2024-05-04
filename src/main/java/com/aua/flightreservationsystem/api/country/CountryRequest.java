package com.aua.flightreservationsystem.api.country;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class CountryRequest {
    String name;
}
