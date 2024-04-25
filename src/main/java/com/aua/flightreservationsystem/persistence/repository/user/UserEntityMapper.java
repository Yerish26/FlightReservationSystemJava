package com.aua.flightreservationsystem.persistence.repository.user;

import com.aua.flightreservationsystem.core.user.User;
import com.aua.flightreservationsystem.persistence.model.FullName;
import com.aua.flightreservationsystem.persistence.model.UserEntity;
import org.springframework.stereotype.Component;


// TODO investigate in the future if there is a better way to write this
@Component
public class UserEntityMapper {
    public User map(UserEntity userEntity) {
        return User.builder()
                .id(userEntity.getId())
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                .firstName(userEntity.getFullName().getFirstName())
                .lastName(userEntity.getFullName().getLastName())
                .role(userEntity.getRole())
                .build();
    }

    public UserEntity map(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(user.getPassword());
        userEntity.setFullName(new FullName(user.getFirstName(), user.getLastName()));
        userEntity.setRole(user.getRole());

        return userEntity;
    }
}
