package com.database.fitnessTracker.service;

import com.database.fitnessTracker.dto.Authentification.AuthenticationRequest;
import com.database.fitnessTracker.dto.Authentification.AuthenticationResponse;
import com.database.fitnessTracker.controller.RegisterRequest;
import com.database.fitnessTracker.entity.Role;
import com.database.fitnessTracker.entity.Users;
import com.database.fitnessTracker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        Users user = Users.builder()
                .login(request.getLogin())
                .password(request.getPassword())
                .email(request.getEmail())
                .weight(request.getWeight())
                .height(request.getHeight())
                .gender(request.getGender())
                .purpose(request.getPurpose())
                .role(Role.USER)
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(Map.of("role",user.getRole()) , user);
        return new AuthenticationResponse(jwtToken);
    }

    public AuthenticationResponse authentication(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getLogin(),
                        request.getPassword()
                )
        );
        Users user = repository.findByLogin(request.getLogin()).orElseThrow();
        var jwtToken = jwtService.generateToken(Map.of("role", user.getRole()), user);
        return new AuthenticationResponse(jwtToken);
    }
}
