package com.aua.flightreservationsystem.core.country;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder(toBuilder = true)
public class Country {
    UUID id;
    String name;
}
