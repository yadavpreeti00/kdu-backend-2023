package com.preeti.miniProject.controller;

import com.preeti.miniProject.entity.Home;
import com.preeti.miniProject.entity.UserHome;
import com.preeti.miniProject.model.AddUserToHomeRequest;
import com.preeti.miniProject.service.UserHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/home")
public class UserHomeController
{

    @Autowired
    UserHomeService userHomeService;
    @PostMapping("/add/user")
    public ResponseEntity<UUID> addUserToHome(@RequestBody AddUserToHomeRequest addUserToHomeRequest)
    {
        return ResponseEntity.ok(userHomeService.addUser(addUserToHomeRequest));
    }
}
