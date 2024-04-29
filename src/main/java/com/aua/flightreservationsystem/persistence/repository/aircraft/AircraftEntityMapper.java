package com.aua.flightreservationsystem.persistence.repository.aircraft;

import com.aua.flightreservationsystem.core.aircraft.Aircraft;
import com.aua.flightreservationsystem.core.aircraftFactory.AircraftFactory;
import com.aua.flightreservationsystem.persistence.model.AircraftEntity;
import com.aua.flightreservationsystem.persistence.model.AircraftFactoryEntity;
import org.springframework.stereotype.Component;

@Component
public class AircraftEntityMapper {
    public Aircraft map(AircraftEntity aircraftEntity) {
        return Aircraft.builder()
                .id(aircraftEntity.getId())
                .modelName(aircraftEntity.getModelName())
                .numberOfSeats(aircraftEntity.getNumberOfSeats())
                .aircraftFactoryId(aircraftEntity.getAircraftFactory().getId())
                .build();
    }

    public AircraftEntity map(Aircraft aircraft) {
        AircraftEntity aircraftEntity = new AircraftEntity();
        aircraftEntity.setId(aircraft.getId());
        aircraftEntity.setModelName(aircraft.getModelName());
        aircraftEntity.setNumberOfSeats(aircraft.getNumberOfSeats());
        aircraftEntity.setAircraftFactory(new AircraftFactoryEntity());

        // TODO Check
        AircraftFactoryEntity aircraftFactoryEntity = new AircraftFactoryEntity();
        aircraftFactoryEntity.setId(aircraftFactoryEntity.getId());
        aircraftEntity.setAircraftFactory(aircraftFactoryEntity);

        return aircraftEntity;
    }

}