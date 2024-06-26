package com.aua.flightreservationsystem.persistence.repository.city;

import com.aua.flightreservationsystem.persistence.model.CityEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<CityEntity, UUID> {}
