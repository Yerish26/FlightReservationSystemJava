package com.aua.flightreservationsystem.core.country;

import java.util.UUID;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class Country {
    UUID id;
    String name;
}
