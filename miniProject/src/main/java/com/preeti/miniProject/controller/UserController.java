package com.preeti.miniProject.controller;

import com.preeti.miniProject.auth.AuthenticationResponse;
import com.preeti.miniProject.model.request.UserRegisterRequest;
import com.preeti.miniProject.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth/user")
public class UserController {

    @Autowired
    AuthenticationService authenticationService;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody UserRegisterRequest userRegisterRequest)
    {
        return ResponseEntity.ok(authenticationService.register(userRegisterRequest));
    }
}
