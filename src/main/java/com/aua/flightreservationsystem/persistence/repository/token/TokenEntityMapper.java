package com.aua.flightreservationsystem.persistence.repository.token;

import com.aua.flightreservationsystem.core.jwt.Token;
import com.aua.flightreservationsystem.persistence.model.TokenEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TokenEntityMapper {
    Token map(TokenEntity tokenEntity);
    TokenEntity map(Token token);
}
