package com.aua.flightreservationsystem.core.city;


import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class City {
    UUID id;
    String name;
}
