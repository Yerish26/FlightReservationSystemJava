package com.aua.flightreservationsystem.persistence.repository.country;

import com.aua.flightreservationsystem.core.country.Country;
import com.aua.flightreservationsystem.persistence.model.CountryEntity;
import org.springframework.stereotype.Component;

@Component
public class CountryEntityMapper {

    public Country map(CountryEntity countryEntity) {
        return Country.builder()
                .id(countryEntity.getId())
                .name(countryEntity.getName())
                .build();
    }

    public CountryEntity map(Country country) {
        CountryEntity countryEntity = new CountryEntity();
        countryEntity.setId(country.getId());
        countryEntity.setName(country.getName());
        return countryEntity;
    }
}
