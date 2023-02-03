package com.preeti.miniProject.controller;

import com.preeti.miniProject.entity.UserHome;
import com.preeti.miniProject.model.request.AddUserToHomeRequest;
import com.preeti.miniProject.service.UserHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping("/findAll/{userId}")
    public ResponseEntity<List<UserHome>> listAllHome(@PathVariable UUID userId)
    {
        return ResponseEntity.ok(userHomeService.listAllHome(userId));
    }
}
