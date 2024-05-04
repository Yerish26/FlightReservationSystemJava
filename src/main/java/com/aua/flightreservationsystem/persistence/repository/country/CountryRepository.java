package com.aua.flightreservationsystem.persistence.repository.country;

import com.aua.flightreservationsystem.persistence.model.CountryEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<CountryEntity, UUID> {}
