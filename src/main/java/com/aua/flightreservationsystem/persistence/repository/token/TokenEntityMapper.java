package com.aua.flightreservationsystem.persistence.repository.token;

import com.aua.flightreservationsystem.core.jwt.Token;
import com.aua.flightreservationsystem.persistence.model.TokenEntity;
import com.aua.flightreservationsystem.persistence.repository.user.UserEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class TokenEntityMapper {
    private final UserEntityMapper userEntityMapper;

    public TokenEntityMapper(UserEntityMapper userEntityMapper) {
        this.userEntityMapper = userEntityMapper;
    }

    public Token map(TokenEntity tokenEntity) {
        return Token.builder()
                .id(tokenEntity.getId())
                .loggedOut(tokenEntity.isLoggedOut())
                .token(tokenEntity.getToken())
                .user(userEntityMapper.map(tokenEntity.getUser()))
                .build();
    }

    public TokenEntity map(Token token) {
        TokenEntity tokenEntity = new TokenEntity();
        tokenEntity.setId(token.getId());
        tokenEntity.setLoggedOut(token.isLoggedOut());
        tokenEntity.setToken(token.getToken());
        tokenEntity.setUser(userEntityMapper.map(token.getUser()));
        return tokenEntity;
    }
}
