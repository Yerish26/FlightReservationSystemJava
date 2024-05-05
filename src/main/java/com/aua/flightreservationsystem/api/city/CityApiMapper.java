package com.aua.flightreservationsystem.api.city;

import com.aua.flightreservationsystem.core.city.City;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CityApiMapper {
    CityResponse map(City city);
}
