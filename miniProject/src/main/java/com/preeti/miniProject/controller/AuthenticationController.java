package com.preeti.miniProject.controller;


import com.preeti.miniProject.auth.AuthenticationRequest;
import com.preeti.miniProject.auth.AuthenticationResponse;
import com.preeti.miniProject.model.request.UserRegisterRequest;
import com.preeti.miniProject.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {


    private final AuthenticationService authenticationService;


    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody UserRegisterRequest userRegisterRequest
            )
    {
        return ResponseEntity.ok(authenticationService.register(userRegisterRequest));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    )
    {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }



}