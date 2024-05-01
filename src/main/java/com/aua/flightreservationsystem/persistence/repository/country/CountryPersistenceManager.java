package com.aua.flightreservationsystem.persistence.repository.country;

import com.aua.flightreservationsystem.core.country.Country;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CountryPersistenceManager {
    List<Country> findAll();
    Optional<Country> findById(UUID id);
    Country save(Country country);
    void delete(UUID id);
}
