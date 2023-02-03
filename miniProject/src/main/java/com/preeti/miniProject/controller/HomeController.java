package com.preeti.miniProject.controller;

import com.preeti.miniProject.entity.Home;
import com.preeti.miniProject.entity.UserHome;
import com.preeti.miniProject.model.response.ReverseGeoCodingResponseData;
import com.preeti.miniProject.service.HomeService;
import com.preeti.miniProject.service.ReverseGeoCodingService;
import com.preeti.miniProject.service.UserHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/home")
public class HomeController {

    @Autowired
    UserHomeService userHomeService;
    @Autowired
    HomeService homeService;
    @Autowired
    ReverseGeoCodingService reverseGeoCodingService;

    @PostMapping("/create")
    public ResponseEntity<UserHome> create(@RequestBody Home home)
    {
        if(home.getLongitude()!=null && home.getLatitude()!=null)
        {
            home.setAddress(reverseGeoCodingService.getAddress(home.getLatitude(),home.getLongitude()));
        }
        return ResponseEntity.ok(userHomeService.addUserHomeAdmin(home));
    }

    @PutMapping("/update/address/{homeId}")
    public ResponseEntity<Home>updateAddress(@RequestBody String address, @PathVariable UUID homeId)
    {
        return ResponseEntity.ok(homeService.updateAddress(address,homeId));
    }
}
