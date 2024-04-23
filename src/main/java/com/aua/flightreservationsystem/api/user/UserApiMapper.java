package com.aua.flightreservationsystem.api.user;

import com.aua.flightreservationsystem.core.user.User;
import com.aua.flightreservationsystem.persistence.model.AuthenticationResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserApiMapper {

    UserResponse map(AuthenticationResponse response);

    User map(UserRequest userRequest);

    User map(String token);
}
