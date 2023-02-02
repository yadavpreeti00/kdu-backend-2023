package com.preeti.miniProject.controller;

import com.preeti.miniProject.entity.Home;
import com.preeti.miniProject.entity.UserHome;
import com.preeti.miniProject.service.UserHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/home")
public class HomeController {

    @Autowired
    UserHomeService userHomeService;

    @PostMapping("/create")
    public ResponseEntity<UserHome> create(@RequestBody Home home)
    {
        return ResponseEntity.ok(userHomeService.addUserHomeAdmin(home));
    }
}
