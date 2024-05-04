package com.aua.flightreservationsystem.persistence.repository.airline;

import com.aua.flightreservationsystem.persistence.model.AirlineEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirlineRepository extends JpaRepository<AirlineEntity, UUID> {}
