package com.aua.flightreservationsystem.persistence.repository.passportInfo;

import com.aua.flightreservationsystem.core.passportInfo.PassportInfo;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PassportInfoJpaPersistenceManager implements PassportInfoPersistenceManager {

    private final PassportInfoRepository passportInfoRepository;

    private final PassportInfoEntityMapper passportInfoEntityMapper;

    @Override
    public List<PassportInfo> findAll() {
        return passportInfoRepository.findAll().stream()
                .map(passportInfoEntityMapper::map)
                .toList();
    }

    @Override
    public Optional<PassportInfo> findById(UUID id) {
        return passportInfoRepository.findById(id).map(passportInfoEntityMapper::map);
    }

    @Override
    public PassportInfo save(PassportInfo flight) {
        return passportInfoEntityMapper.map(passportInfoRepository.save(passportInfoEntityMapper.map(flight)));
    }

    @Override
    public void delete(UUID id) {
        passportInfoRepository.deleteById(id);
    }

    @Override
    public List<PassportInfo> findAllById(List<UUID> ids) {
        return passportInfoRepository.findAllById(ids).stream()
                .map(passportInfoEntityMapper::map)
                .toList();
    }
}
