package com.aua.flightreservationsystem.persistence.repository;

import com.aua.flightreservationsystem.persistence.model.TokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<TokenEntity, Long> {

    List<TokenEntity> findAllTokensByCustomer(Long customerId);

    Optional<TokenEntity> findByTokenId(Long customerId);

    Optional<TokenEntity> findByToken(String token);
}
