package com.aua.flightreservationsystem.core.passportInfo;

import com.aua.flightreservationsystem.core.country.Country;
import java.util.Date;
import java.util.UUID;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PassportInfo {
    UUID id;
    String passportNumber;
    Country country;
    Date dateOfBirth;
    Date passportExpires;
}
