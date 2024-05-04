package com.aua.flightreservationsystem.api.flight;

import java.util.Date;
import java.util.UUID;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class FlightRequest {
    UUID source;
    UUID destination;
    Date date;
}
