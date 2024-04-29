package com.aua.flightreservationsystem.persistence.repository.airline;

import com.aua.flightreservationsystem.persistence.model.AirlineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AirlineRepository extends JpaRepository<AirlineEntity, UUID> {
}
