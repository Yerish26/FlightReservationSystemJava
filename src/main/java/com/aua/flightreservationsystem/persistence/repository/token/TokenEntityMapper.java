package com.aua.flightreservationsystem.persistence.repository.token;

import com.aua.flightreservationsystem.core.jwt.Token;
import com.aua.flightreservationsystem.persistence.model.TokenEntity;
import org.springframework.stereotype.Component;

@Component
public class TokenEntityMapper {
    public Token map(TokenEntity tokenEntity) {
        return Token.builder()
                .tokenId(tokenEntity.getTokenId())
                .loggedOut(tokenEntity.isLoggedOut())
                .token(tokenEntity.getToken())
                .customer(tokenEntity.getCustomer())
                .build();
    }

    public TokenEntity map(Token token) {
        TokenEntity tokenEntity = new TokenEntity();
        tokenEntity.setTokenId(token.getTokenId());
        tokenEntity.setLoggedOut(token.isLoggedOut());
        tokenEntity.setToken(token.getToken());
        tokenEntity.setCustomer(token.getCustomer());
        return tokenEntity;
    }
}
