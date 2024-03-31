package com.example.authentication;

import com.example.authentication.dtos.AuthenticationRequest;
import com.example.authentication.dtos.AuthenticationResponse;
import com.example.authentication.dtos.RegisterRequest;
import com.example.authentication.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final UserRepository repository;

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody AuthenticationRequest request) {
        return authenticationService.authenticate(request);
    }

    @PostMapping("/register")
    public AuthenticationResponse register(@RequestBody RegisterRequest request) {
        return authenticationService.register(request);
    }

    @GetMapping("/user/{email}")
    public User findByEmail(@PathVariable("email") String email) {
        return repository.findByEmail(email).orElseThrow();
    }
}
