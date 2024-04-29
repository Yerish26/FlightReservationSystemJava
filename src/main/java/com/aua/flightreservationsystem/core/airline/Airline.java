package com.aua.flightreservationsystem.core.airline;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder(toBuilder = true)
public class Airline {
    UUID id;
    String name;
}
