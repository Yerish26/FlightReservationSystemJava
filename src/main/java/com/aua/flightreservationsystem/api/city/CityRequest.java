package com.aua.flightreservationsystem.api.city;

import java.util.List;
import java.util.UUID;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class CityRequest {
    String name;
    UUID country;
    List<UUID> flightIds;
    UUID airport;
}
