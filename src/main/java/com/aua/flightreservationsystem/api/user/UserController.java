package com.aua.flightreservationsystem.api.user;

import com.aua.flightreservationsystem.core.jwt.AuthenticationService;
import com.aua.flightreservationsystem.core.user.User;
import com.aua.flightreservationsystem.core.user.exceptions.UsernameAlreadyExistsException;
import com.aua.flightreservationsystem.core.user.exceptions.UsernameNotFoundException;
import com.aua.flightreservationsystem.persistence.model.AuthenticationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
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

    // TODO error throwing should be handled and added to the requests
    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody UserRequest userRequest) throws UsernameAlreadyExistsException {
        User user = userApiMapper.map(userRequest);
        authenticationService.register(user);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody UserRequest userRequest) throws UsernameNotFoundException, AuthenticationException {
        User user = userApiMapper.map(userRequest);
        AuthenticationResponse authenticationResponse = authenticationService.authenticate(user);
        return ResponseEntity.ok(userApiMapper.map(authenticationResponse));
    }


    @ExceptionHandler(UsernameAlreadyExistsException.class)
    ResponseEntity<String> handleUsernameAlreadyExistsExceptions(UsernameAlreadyExistsException usernameAlreadyExistsException) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(usernameAlreadyExistsException.getMessage());
    }


    @ExceptionHandler(UsernameNotFoundException.class)
    ResponseEntity<String> handleUsernameNotFoundExceptions(UsernameNotFoundException usernameNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(usernameNotFoundException.getMessage());
    }

    @ExceptionHandler(AuthenticationException.class)
    ResponseEntity<String> handleAuthenticationException(AuthenticationException authenticationException) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(authenticationException.getMessage());
    }

}
