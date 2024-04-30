package com.aua.flightreservationsystem.persistence.repository.aircraftFactory;

import com.aua.flightreservationsystem.core.aircraftFactory.AircraftFactory;
import com.aua.flightreservationsystem.persistence.model.AircraftFactoryEntity;
import com.aua.flightreservationsystem.persistence.repository.aircraft.AircraftEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class AircraftFactoryEntityMapper {
    private final AircraftEntityMapper aircraftEntityMapper;

    public AircraftFactoryEntityMapper(AircraftEntityMapper aircraftEntityMapper) {
        this.aircraftEntityMapper = aircraftEntityMapper;
    }

    public AircraftFactory map(AircraftFactoryEntity aircraftFactoryEntity) {
        return AircraftFactory.builder()
                .id(aircraftFactoryEntity.getId())
                .modelName(aircraftFactoryEntity.getModelName())
                .aircraft(aircraftFactoryEntity.getAircrafts().stream().map(aircraftEntityMapper::map).toList())
                .build();
    }

    public AircraftFactoryEntity map(AircraftFactory aircraftFactory){
        AircraftFactoryEntity aircraftFactoryEntity = new AircraftFactoryEntity();
        aircraftFactoryEntity.setId(aircraftFactory.getId());
        aircraftFactoryEntity.setModelName(aircraftFactory.getModelName());
        aircraftFactoryEntity.setAircrafts(aircraftFactory.getAircraft().stream().map(aircraftEntityMapper::map).toList());
        return aircraftFactoryEntity;
    }
}
