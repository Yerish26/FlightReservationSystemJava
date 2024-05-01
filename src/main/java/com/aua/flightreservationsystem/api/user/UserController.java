package com.aua.flightreservationsystem.api.user;

import com.aua.flightreservationsystem.core.jwt.AuthenticationService;
import com.aua.flightreservationsystem.core.user.User;
import com.aua.flightreservationsystem.core.user.exceptions.UsernameAlreadyExistsException;
import com.aua.flightreservationsystem.core.user.exceptions.UsernameNotFoundException;
import com.aua.flightreservationsystem.core.jwt.AuthenticationResponse;
import com.aua.flightreservationsystem.persistence.model.Role;
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

    public ResponseEntity<Void> registerUser(@RequestBody UserRequest userRequest, Role role) throws UsernameAlreadyExistsException {
        User user = userApiMapper.map(userRequest);
        User createdUser = user.toBuilder().role(role).build();
        authenticationService.register(createdUser);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    // TODO this should be hidden some other way for it to be completely secure
    //  but for this current purpose it is fine
    // or done by migration or the project setup
    @PostMapping("/register_admin")
    public ResponseEntity<Void> registerAdmin(@RequestBody UserRequest userRequest) throws UsernameAlreadyExistsException {
        return registerUser(userRequest, Role.ADMIN);
    }

    @PostMapping("/admin_only/register_employee")
    public ResponseEntity<Void> registerEmployee(@RequestBody UserRequest userRequest) throws UsernameAlreadyExistsException {
        return registerUser(userRequest, Role.EMPLOYEE);
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody UserRequest userRequest) throws UsernameAlreadyExistsException {
        return registerUser(userRequest, Role.CUSTOMER);
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
