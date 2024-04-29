package com.aua.flightreservationsystem.persistence.repository.airline;
import com.aua.flightreservationsystem.core.airline.Airline;
import com.aua.flightreservationsystem.persistence.model.AirlineEntity;
import org.springframework.stereotype.Component;

@Component
public class AirlineEntityMapper {
    public Airline map(AirlineEntity airlineEntity) {
        return Airline.builder()
                .id(airlineEntity.getId())
                .name(airlineEntity.getName())
                .build();
    }
    public AirlineEntity map(Airline airline) {
        AirlineEntity airlineEntity = new AirlineEntity();
        airlineEntity.setId(airline.getId());
        airlineEntity.setName(airline.getName());
        return airlineEntity;
    }
}
