package com.aua.flightreservationsystem.api.user;

import com.aua.flightreservationsystem.core.user.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserApiMapper {

    UserResponse map(User user);

    User map(UserRequest userRequest);

    User map(String token);
}
