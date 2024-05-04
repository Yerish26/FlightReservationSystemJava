package com.aua.flightreservationsystem.persistence.repository.airport;

import com.aua.flightreservationsystem.persistence.model.AirportEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<AirportEntity, UUID> {}
