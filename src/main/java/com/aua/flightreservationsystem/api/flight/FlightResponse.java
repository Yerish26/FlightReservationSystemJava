package com.aua.flightreservationsystem.api.flight;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.Date;


@Value
@Builder
@Jacksonized
public class FlightResponse {
    Long flightId;
    String source;
    String destination;
    Date date;
}
