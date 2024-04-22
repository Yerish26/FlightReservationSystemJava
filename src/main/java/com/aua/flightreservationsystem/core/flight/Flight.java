package com.aua.flightreservationsystem.core.flight;

import lombok.Builder;
import lombok.Value;

import java.util.Date;

@Value
@Builder
public class Flight {
    Long flightId;
    String source;
    String destination;
    Date date;
}
