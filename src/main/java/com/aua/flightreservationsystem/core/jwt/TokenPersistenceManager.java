package com.aua.flightreservationsystem.core.jwt;

import java.util.List;
import java.util.Optional;

public interface TokenPersistenceManager {

    List<Token> findAllTokens();

    Optional<Token> findById(Long id);

    Token saveToken(Token token);

    void deleteToken(Long tokenId);
}
