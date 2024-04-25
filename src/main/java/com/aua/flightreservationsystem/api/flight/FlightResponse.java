package com.aua.flightreservationsystem.api.flight;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.Date;
import java.util.UUID;


@Value
@Builder
@Jacksonized
public class FlightResponse {
    UUID id;
    Date date;
}
