package com.aua.flightreservationsystem.persistence.repository.token;

import com.aua.flightreservationsystem.core.jwt.Token;

import java.util.List;
import java.util.Optional;

public interface TokenPersistenceManager {

    List<Token> findAllTokens();

    List<Token> findAllTokensByUser(Long id);

    Optional<Token> findById(Long id);

    Token saveToken(Token token);


    void saveAll(List<Token> tokens);

    void deleteToken(Long tokenId);
}
