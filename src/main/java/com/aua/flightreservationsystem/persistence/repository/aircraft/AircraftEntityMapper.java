package com.aua.flightreservationsystem.persistence.repository.aircraft;

import com.aua.flightreservationsystem.core.aircraft.Aircraft;
import com.aua.flightreservationsystem.core.aircraftFactory.AircraftFactory;
import com.aua.flightreservationsystem.persistence.model.AircraftEntity;
import com.aua.flightreservationsystem.persistence.model.AircraftFactoryEntity;
import com.aua.flightreservationsystem.persistence.repository.aircraftFactory.AircraftFactoryEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class AircraftEntityMapper {
    private final AircraftFactoryEntityMapper aircraftFactoryEntityMapper;

    public AircraftEntityMapper(AircraftFactoryEntityMapper aircraftFactoryEntityMapper) {
        this.aircraftFactoryEntityMapper = aircraftFactoryEntityMapper;
    }

    public Aircraft map(AircraftEntity aircraftEntity) {
        return Aircraft.builder()
                .id(aircraftEntity.getId())
                .modelName(aircraftEntity.getModelName())
                .numberOfSeats(aircraftEntity.getNumberOfSeats())
                .aircraftFactory(aircraftFactoryEntityMapper.map(aircraftEntity.getAircraftFactory()))
                .build();
    }

    public AircraftEntity map(Aircraft aircraft) {
        AircraftEntity aircraftEntity = new AircraftEntity();
        aircraftEntity.setId(aircraft.getId());
        aircraftEntity.setModelName(aircraft.getModelName());
        aircraftEntity.setNumberOfSeats(aircraft.getNumberOfSeats());
        aircraftEntity.setAircraftFactory(aircraftFactoryEntityMapper.map(aircraft.getAircraftFactory()));
        return aircraftEntity;
    }

}