package com.aua.flightreservationsystem.persistence.repository.token;

import com.aua.flightreservationsystem.core.jwt.Token;
import com.aua.flightreservationsystem.core.jwt.TokenPersistenceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

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
    public Optional<Token> findById(Long id) {
        return tokenRepository.findByTokenId(id).map(tokenEntityMapper::map);
    }

    @Override
    public Token saveToken(Token token) {
        return tokenEntityMapper.map(tokenRepository.save(tokenEntityMapper.map(token)));
    }

    @Override
    public void deleteToken(Long tokenId) {
        tokenRepository.deleteById(tokenId);
    }


}
