package com.aua.flightreservationsystem.persistence.repository.flight;

import com.aua.flightreservationsystem.persistence.model.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FlightRepository extends JpaRepository<FlightEntity, UUID> {
}
