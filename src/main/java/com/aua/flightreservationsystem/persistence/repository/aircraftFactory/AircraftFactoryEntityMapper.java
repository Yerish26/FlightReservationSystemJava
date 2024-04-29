package com.aua.flightreservationsystem.persistence.repository.aircraftFactory;

import com.aua.flightreservationsystem.core.aircraftFactory.AircraftFactory;
import com.aua.flightreservationsystem.persistence.model.AircraftFactoryEntity;
import org.springframework.stereotype.Component;

@Component
public class AircraftFactoryEntityMapper {

    public AircraftFactory map(AircraftFactoryEntity aircraftFactoryEntity) {
        return AircraftFactory.builder()
                .id(aircraftFactoryEntity.getId())
                .modelName(aircraftFactoryEntity.getModelName())
                .build();
    }

    public AircraftFactoryEntity map(AircraftFactory aircraftFactory){
        AircraftFactoryEntity aircraftFactoryEntity = new AircraftFactoryEntity();
        aircraftFactoryEntity.setId(aircraftFactory.getId());
        aircraftFactoryEntity.setModelName(aircraftFactory.getModelName());
        return aircraftFactoryEntity;
    }
}
