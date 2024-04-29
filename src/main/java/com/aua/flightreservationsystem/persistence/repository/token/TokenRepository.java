package com.aua.flightreservationsystem.persistence.repository.token;

import com.aua.flightreservationsystem.persistence.model.TokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TokenRepository extends JpaRepository<TokenEntity, UUID> {

    List<TokenEntity> findAllTokensByUserId(UUID id);

    Optional<TokenEntity> findByToken(String token);
}
