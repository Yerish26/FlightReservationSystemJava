package com.aua.flightreservationsystem.core.city;

import com.aua.flightreservationsystem.core.airport.Airport;
import com.aua.flightreservationsystem.core.country.Country;
import com.aua.flightreservationsystem.core.flight.Flight;
import java.util.List;
import java.util.UUID;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class City {
    UUID id;
    String name;
    Country country;
    List<Flight> flights;
    Airport airport;
}
