package com.aua.flightreservationsystem.persistence.repository.airport;

import com.aua.flightreservationsystem.core.airport.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AirportRepository extends JpaRepository<Airport, UUID> {
}
