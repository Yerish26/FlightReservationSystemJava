package com.aua.flightreservationsystem.persistence.repository.airline;

import com.aua.flightreservationsystem.core.airline.Airline;
import com.aua.flightreservationsystem.persistence.model.AirlineEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AirlineEntityMapper {
  Airline map(AirlineEntity airlineEntity);
  AirlineEntity map(Airline airline);
}
