package com.aua.flightreservationsystem.persistence.repository.flight;

import com.aua.flightreservationsystem.persistence.model.FlightEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<FlightEntity, UUID> {
    boolean existsByIdIn(List<UUID> ids);
}
