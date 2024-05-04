package com.aua.flightreservationsystem.core.airline;

import com.aua.flightreservationsystem.core.flight.Flight;
import java.util.List;
import java.util.UUID;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class Airline {
    UUID id;
    String name;
    List<Flight> flights;
}
