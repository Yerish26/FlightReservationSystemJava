package com.aua.flightreservationsystem.api.user;

import com.aua.flightreservationsystem.core.jwt.AuthenticationService;
import com.aua.flightreservationsystem.core.user.User;
import com.aua.flightreservationsystem.core.user.exceptions.UsernameAlreadyExistsException;
import com.aua.flightreservationsystem.core.user.exceptions.UsernameNotFoundException;
import com.aua.flightreservationsystem.persistence.model.AuthenticationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final AuthenticationService authenticationService;
    private final UserApiMapper userApiMapper;

    public UserController(AuthenticationService authenticationService, UserApiMapper userApiMapper) {
        this.authenticationService = authenticationService;
        this.userApiMapper = userApiMapper;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody UserRequest userRequest) {
        User user = userApiMapper.map(userRequest);
        AuthenticationResponse authenticationResponse = authenticationService.register(user);
        return ResponseEntity.ok(userApiMapper.map(authenticationResponse));
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody UserRequest userRequest) throws UsernameNotFoundException {
        User user = userApiMapper.map(userRequest);
        AuthenticationResponse authenticationResponse = authenticationService.authenticate(user);
        return ResponseEntity.ok(userApiMapper.map(authenticationResponse));
    }


    @ExceptionHandler(UsernameAlreadyExistsException.class)
    ResponseEntity<String> handleUsernameAlreadyExistsExceptions(UsernameAlreadyExistsException usernameAlreadyExistsException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(usernameAlreadyExistsException.getMessage());
    }


    @ExceptionHandler(UsernameNotFoundException.class)
    ResponseEntity<String> handleUsernameNotFoundExceptions(UsernameNotFoundException usernameNotFoundException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(usernameNotFoundException.getMessage());
    }

}
