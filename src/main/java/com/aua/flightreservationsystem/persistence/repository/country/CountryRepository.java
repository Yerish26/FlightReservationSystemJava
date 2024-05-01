package com.aua.flightreservationsystem.persistence.repository.country;

import com.aua.flightreservationsystem.persistence.model.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CountryRepository extends JpaRepository<CountryEntity, UUID> {
}
