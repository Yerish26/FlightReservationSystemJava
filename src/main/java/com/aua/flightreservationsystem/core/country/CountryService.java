package com.aua.flightreservationsystem.core.country;

import com.aua.flightreservationsystem.api.country.CountryRequest;
import com.aua.flightreservationsystem.persistence.repository.country.CountryPersistenceManager;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CountryService {
    private final CountryPersistenceManager countryPersistenceManager;

    public List<Country> getAll() {
        return countryPersistenceManager.findAll();
    }

    public Optional<Country> getById(UUID id) {
        return countryPersistenceManager.findById(id);
    }

    public Country save(CountryRequest countryRequest) {
        Country country = getCountry(countryRequest);
        return countryPersistenceManager.save(country);
    }

    public Country update(UUID id, CountryRequest countryRequest) {
        Optional<Country> countryOptional = countryPersistenceManager.findById(id);
        if (countryOptional.isEmpty()) {
            return save(countryRequest);
        }

        Country aircraftFactory = getCountry(countryRequest).toBuilder().id(id).build();

        return countryPersistenceManager.save(aircraftFactory);
    }

    private static Country getCountry(CountryRequest countryRequest) {
        return Country.builder().name(countryRequest.getName()).build();
    }

    public void delete(UUID id) {
        countryPersistenceManager.delete(id);
    }
}
