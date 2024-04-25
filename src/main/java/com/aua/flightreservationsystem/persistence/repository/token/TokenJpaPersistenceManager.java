package com.aua.flightreservationsystem.persistence.repository.token;

import com.aua.flightreservationsystem.core.jwt.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TokenJpaPersistenceManager implements TokenPersistenceManager {

    private final TokenRepository tokenRepository;
    private final TokenEntityMapper tokenEntityMapper;

    @Autowired
    public TokenJpaPersistenceManager(TokenRepository tokenRepository, TokenEntityMapper tokenEntityMapper) {
        this.tokenRepository = tokenRepository;
        this.tokenEntityMapper = tokenEntityMapper;
    }


    @Override
    public List<Token> findAllTokens() {
        return tokenRepository.findAll().stream().map(tokenEntityMapper::map).toList();
    }

    @Override
    public List<Token> findAllTokensByUser(UUID id) {
        return tokenRepository.findAllTokensByUserId(id).stream().map(tokenEntityMapper::map).toList();
    }

    @Override
    public Optional<Token> findById(UUID id) {
        return tokenRepository.findByTokenId(id).map(tokenEntityMapper::map);
    }

    @Override
    public void save(Token token) {
        tokenRepository.save(tokenEntityMapper.map(token));
    }

    @Override
    public void saveAll(List<Token> tokens) {

    }

    @Override
    public void deleteToken(UUID id) {
        tokenRepository.deleteById(id);
    }
}
