package com.aua.flightreservationsystem.core.city;


import lombok.Builder;
import lombok.Value;
import org.springframework.lang.Nullable;

import java.util.UUID;

@Value
@Builder
public class City {
    UUID id;

    @Nullable
    String name;
}
