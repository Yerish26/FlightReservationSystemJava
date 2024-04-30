package com.aua.flightreservationsystem.persistence.repository.city;

import com.aua.flightreservationsystem.core.city.City;
import com.aua.flightreservationsystem.persistence.model.CityEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CityEntityMapper {
    City map(CityEntity cityEntity);
    CityEntity map(City city);
}
