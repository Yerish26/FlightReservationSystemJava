package com.aua.flightreservationsystem.core.flight;

import com.aua.flightreservationsystem.core.city.City;
import lombok.Builder;
import lombok.Value;

import java.util.Date;
import java.util.UUID;

@Value
@Builder
public class Flight {
    UUID id;
    City source;
    City destination;
    Date time;
}
