package com.aua.flightreservationsystem.persistence.repository.city;

import com.aua.flightreservationsystem.core.city.City;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CityPersistenceManager {

    List<City> findAllCities();
    Optional<City> findById(UUID id);
    City saveCity(City city);
    void deleteCity(UUID id);

}
