package com.aua.flightreservationsystem.core.jwt;

import com.aua.flightreservationsystem.core.user.User;
import com.aua.flightreservationsystem.persistence.model.AuthenticationResponse;
import com.aua.flightreservationsystem.persistence.model.UserEntity;
import com.aua.flightreservationsystem.persistence.repository.token.TokenPersistenceManager;
import com.aua.flightreservationsystem.persistence.repository.user.UserEntityMapper;
import com.aua.flightreservationsystem.persistence.repository.user.UserPersistenceManager;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthenticationService {

    private final UserPersistenceManager userPersistenceManager;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    private final TokenPersistenceManager tokenPersistenceManager;

    private final AuthenticationManager authenticationManager;

    private final UserEntityMapper userEntityMapper;

    public AuthenticationService(UserPersistenceManager userPersistenceManager,
                                 PasswordEncoder passwordEncoder,
                                 JwtService jwtService,
                                 TokenPersistenceManager tokenPersistanceManager,
                                 AuthenticationManager authenticationManager,
                                 UserEntityMapper userEntityMapper
    ) {
        this.userPersistenceManager = userPersistenceManager;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.tokenPersistenceManager = tokenPersistanceManager;
        this.authenticationManager = authenticationManager;
        this.userEntityMapper = userEntityMapper;
    }

    public AuthenticationResponse register(User request) {

        // check if user already exist. if exist than authenticate the user
        if(userPersistenceManager.findByUsername(request.getUsername()).isPresent()) {
            return new AuthenticationResponse(null, "User already exist");
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(request.getFirstName());
        userEntity.setLastName(request.getLastName());
        userEntity.setUsername(request.getUsername());
        userEntity.setPassword(passwordEncoder.encode(request.getPassword()));


        userEntity.setRole(request.getRole());

        User savedUser = userPersistenceManager.save(userEntityMapper.map(userEntity));

        String jwt = jwtService.generateToken(savedUser);

        saveUserToken(jwt, savedUser);

        return new AuthenticationResponse(jwt, "User registration was successful");

    }

    public AuthenticationResponse authenticate(User request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        User user = userPersistenceManager.findByUsername(request.getUsername()).orElseThrow();
        String jwt = jwtService.generateToken(user);

        revokeAllTokenByUser(user);
        saveUserToken(jwt, user);

        return new AuthenticationResponse(jwt, "User login was successful");

    }
    private void revokeAllTokenByUser(User user) {
        List<Token> validTokens = tokenPersistenceManager.findAllTokensByUser(user.getId());
        if(validTokens.isEmpty()) {
            return;
        }

        validTokens.forEach(t-> {
//            t.setLoggedOut(true);
        });

        tokenPersistenceManager.saveAll(validTokens);
    }
    private void saveUserToken(String jwt, User user) {
//        Token token = new Token();
//        token.setToken(jwt);
//        token.setLoggedOut(false);
//        token.setUser(user);
//        tokenRepository.save(token);
    }
}