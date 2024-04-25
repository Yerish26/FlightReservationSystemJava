package com.aua.flightreservationsystem.persistence.repository.city;

import com.aua.flightreservationsystem.core.city.City;
import com.aua.flightreservationsystem.persistence.model.CityEntity;
import org.springframework.stereotype.Component;

@Component
public class CityEntityMapper {


    public City map(CityEntity cityEntity) {
        return City.builder()
                .id(cityEntity.getId())
                .name(cityEntity.getName())
                .build();
    }

    public CityEntity map(City city) {
        CityEntity cityEntity = new CityEntity();
        cityEntity.setId(city.getId());
        cityEntity.setName(city.getName());
        return cityEntity;
    }
}
