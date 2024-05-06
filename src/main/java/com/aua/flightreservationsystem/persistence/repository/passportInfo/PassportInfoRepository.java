package com.aua.flightreservationsystem.persistence.repository.passportInfo;

import com.aua.flightreservationsystem.persistence.model.PassportInfoEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportInfoRepository extends JpaRepository<PassportInfoEntity, UUID> {}
