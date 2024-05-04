package com.aua.flightreservationsystem.persistence.repository.country;

import com.aua.flightreservationsystem.core.country.Country;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryJpaPersistenceManager implements CountryPersistenceManager {

    private final CountryRepository countryRepository;
    private final CountryEntityMapper countryEntityMapper;

    @Autowired
    public CountryJpaPersistenceManager(CountryRepository countryRepository, CountryEntityMapper countryEntityMapper) {
        this.countryRepository = countryRepository;
        this.countryEntityMapper = countryEntityMapper;
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll().stream()
                .map(countryEntityMapper::map)
                .toList();
    }

    @Override
    public Optional<Country> findById(UUID id) {
        return countryRepository.findById(id).map(countryEntityMapper::map);
    }

    @Override
    public Country save(Country country) {
        return countryEntityMapper.map(countryRepository.save(countryEntityMapper.map(country)));
    }

    @Override
    public void delete(UUID id) {
        countryRepository.deleteById(id);
    }
}
