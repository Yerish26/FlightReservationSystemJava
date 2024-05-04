package com.aua.flightreservationsystem.api.user;

import com.aua.flightreservationsystem.core.jwt.AuthenticationResponse;
import com.aua.flightreservationsystem.core.user.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserApiMapper {

    LoginResponse map(AuthenticationResponse response);

    User map(UserRequest userRequest);
}
