package com.preeti.miniProject.controller;

import com.preeti.miniProject.service.UserDeviceService;
import com.preeti.miniProject.model.request.AddDeviceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/user/device")
public class UserDeviceController {

    @Autowired
    UserDeviceService userDeviceService;

    @PostMapping("/add")
    public ResponseEntity<UUID> addDevice(@RequestBody AddDeviceRequest addDeviceRequest)
    {
        return ResponseEntity.ok(userDeviceService.addDevice(addDeviceRequest));
    }
}
