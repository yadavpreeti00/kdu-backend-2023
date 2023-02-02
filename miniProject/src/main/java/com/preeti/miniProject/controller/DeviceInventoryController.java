package com.preeti.miniProject.controller;

import com.preeti.miniProject.entity.DeviceInventory;
import com.preeti.miniProject.service.DeviceInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth/device")
public class DeviceInventoryController {

    @Autowired
    DeviceInventoryService deviceInventoryService;

    @PostMapping("/create")
    public ResponseEntity<DeviceInventory> createDevice(@RequestBody DeviceInventory deviceInventory )
    {
        DeviceInventory device=deviceInventoryService.createDevice(deviceInventory);
        return new ResponseEntity<>(device, HttpStatus.CREATED);
    }
}
