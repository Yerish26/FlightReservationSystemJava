package com.aua.flightreservationsystem.core.flight;

import com.aua.flightreservationsystem.core.city.City;
import java.util.Date;
import java.util.UUID;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Flight {
    UUID id;
    City source;
    City destination;
    Date time;
}
