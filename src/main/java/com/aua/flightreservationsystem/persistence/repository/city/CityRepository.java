package com.aua.flightreservationsystem.persistence.repository.city;

import com.aua.flightreservationsystem.persistence.model.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CityRepository extends JpaRepository<CityEntity, UUID> {
}
