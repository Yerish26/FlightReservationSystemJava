package com.aua.flightreservationsystem.persistence.repository.aircraft;

import com.aua.flightreservationsystem.persistence.model.AircraftEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AircraftRepository extends JpaRepository<AircraftEntity, UUID> {}
