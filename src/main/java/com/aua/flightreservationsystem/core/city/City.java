package com.aua.flightreservationsystem.core.city;


import com.aua.flightreservationsystem.core.airport.Airport;
import com.aua.flightreservationsystem.core.country.Country;
import com.aua.flightreservationsystem.core.flight.Flight;
import lombok.Builder;
import lombok.Value;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.UUID;

@Value
@Builder
public class City {
    UUID id;

    @Nullable
    String name;

    Country country;
    List<Flight> flights;
    Airport airport;
}
