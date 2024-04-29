package com.aua.flightreservationsystem.core.airport;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder(toBuilder = true)
public class Airport {
    UUID id;
    UUID cityId;
}
