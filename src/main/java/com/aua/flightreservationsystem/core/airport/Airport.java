package com.aua.flightreservationsystem.core.airport;

import com.aua.flightreservationsystem.core.city.City;
import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder(toBuilder = true)
public class Airport {
    UUID id;
    City city;
}
