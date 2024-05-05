package com.aua.flightreservationsystem.core.airport;

import com.aua.flightreservationsystem.core.city.City;
import java.util.UUID;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class Airport {
    UUID id;
    String name;
    City city;
}
