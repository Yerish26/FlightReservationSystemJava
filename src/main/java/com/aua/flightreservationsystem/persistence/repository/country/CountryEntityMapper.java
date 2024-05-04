package com.aua.flightreservationsystem.persistence.repository.country;

import com.aua.flightreservationsystem.core.country.Country;
import com.aua.flightreservationsystem.persistence.model.CountryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CountryEntityMapper {
    Country map(CountryEntity countryEntity);

    CountryEntity map(Country country);
}
