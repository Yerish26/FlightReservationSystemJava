package com.aua.flightreservationsystem.persistence.repository.city;

import com.aua.flightreservationsystem.core.city.City;
import com.aua.flightreservationsystem.persistence.model.CityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CityJpaPersistenceManager implements CityPersistenceManager {
    private final CityRepository cityRepository;
    private final CityEntityMapper cityEntityMapper;

    @Autowired
    public CityJpaPersistenceManager(CityRepository cityRepository, CityEntityMapper cityEntityMapper) {
        this.cityRepository = cityRepository;
        this.cityEntityMapper = cityEntityMapper;
    }

    @Override
    public List<City> findAll() {
        return cityRepository.findAll().stream().map(cityEntityMapper::map).toList();
    }

    @Override
    public Optional<City> findById(UUID id) {
        return cityRepository.findById(id).map(cityEntityMapper::map);
    }

    @Override
    public City save(City city) {
        return cityEntityMapper.map(cityRepository.save(cityEntityMapper.map(city)));
    }

    @Override
    public void delete(UUID id) {
        cityRepository.deleteById(id);
    }
}
