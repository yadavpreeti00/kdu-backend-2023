package com.preeti.spring4.controller;


import com.preeti.spring4.auth.AuthenticationRequest;
import com.preeti.spring4.auth.AuthenticationResponse;
import com.preeti.spring4.auth.RegisterRequest;
import com.preeti.spring4.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {


    private final AuthenticationService service;

    /**
     * @param request to register a new user and has authority of admin
     * @return
     */
    @PostMapping("/register")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    )
    {
        return ResponseEntity.ok(service.register(request));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    )
    {
        return ResponseEntity.ok(service.authenticate(request));
    }


    /**
     * @param request To create Admin at the 1st time
     * @return
     */
    @PostMapping("/register/admin")
    public ResponseEntity<AuthenticationResponse> registerAdmin(
            @RequestBody RegisterRequest request
    )
    {
        return ResponseEntity.ok(service.register(request));
    }
}