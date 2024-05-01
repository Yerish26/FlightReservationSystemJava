package com.aua.flightreservationsystem.core.flight;

import com.aua.flightreservationsystem.core.city.City;
import lombok.Builder;
import lombok.Value;
import org.springframework.lang.Nullable;

import java.util.Date;
import java.util.UUID;

@Value
@Builder
public class Flight {
    UUID id;
    @Nullable
    City source;
    @Nullable
    City destination;
    @Nullable
    Date time;
}
