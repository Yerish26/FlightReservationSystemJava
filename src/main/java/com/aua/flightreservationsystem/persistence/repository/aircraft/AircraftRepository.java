package com.aua.flightreservationsystem.persistence.repository.aircraft;

import com.aua.flightreservationsystem.persistence.model.AircraftEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AircraftRepository extends JpaRepository<AircraftEntity, UUID> {
}
