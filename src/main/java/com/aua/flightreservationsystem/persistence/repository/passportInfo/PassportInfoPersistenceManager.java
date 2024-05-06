package com.aua.flightreservationsystem.persistence.repository.passportInfo;

import com.aua.flightreservationsystem.core.passportInfo.PassportInfo;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PassportInfoPersistenceManager {
    List<PassportInfo> findAll();

    Optional<PassportInfo> findById(UUID id);

    PassportInfo save(PassportInfo passportInfo);

    void delete(UUID id);

    List<PassportInfo> findAllById(List<UUID> ids);
}
