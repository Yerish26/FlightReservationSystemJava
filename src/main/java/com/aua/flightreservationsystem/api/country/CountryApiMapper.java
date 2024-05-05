package com.aua.flightreservationsystem.api.country;

import com.aua.flightreservationsystem.core.country.Country;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CountryApiMapper {
    CountryResponse map(Country country);
}
