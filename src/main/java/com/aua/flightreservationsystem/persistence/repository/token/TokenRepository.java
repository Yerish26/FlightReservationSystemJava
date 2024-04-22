package com.aua.flightreservationsystem.persistence.repository.token;

import com.aua.flightreservationsystem.persistence.model.TokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<TokenEntity, Long> {

    List<TokenEntity> findAllTokensByUserId(Long userId);

    Optional<TokenEntity> findByTokenId(Long tokenId);

    Optional<TokenEntity> findByToken(String token);
}
