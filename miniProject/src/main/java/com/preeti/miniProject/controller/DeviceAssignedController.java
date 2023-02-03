package com.preeti.miniProject.controller;

import com.preeti.miniProject.entity.DevicesAssigned;
import com.preeti.miniProject.model.request.AddDeviceToHomeRequest;
import com.preeti.miniProject.model.request.MoveDeviceWithinHomeRequest;
import com.preeti.miniProject.service.DevicesAssignedService;
import com.preeti.miniProject.service.UserDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/user/home")
public class DeviceAssignedController {

    @Autowired
    DevicesAssignedService devicesAssignedService;
    @Autowired
    UserDeviceService userDeviceService;

    @PostMapping("/add/device")
    public ResponseEntity<UUID> addDeviceToHome(@RequestBody AddDeviceToHomeRequest addDeviceToHomeRequest)
    {
        return ResponseEntity.ok(userDeviceService.addDeviceToHome(addDeviceToHomeRequest));
    }

    @PutMapping("/move/device")
    public ResponseEntity<UUID> moveDeviceToHome(@RequestBody MoveDeviceWithinHomeRequest moveDeviceWithinHomeRequest)
    {
        return ResponseEntity.ok(userDeviceService.moveDeviceToHome(moveDeviceWithinHomeRequest));
    }

    @GetMapping("/getAll/device/{homeId}")
    public ResponseEntity<List<DevicesAssigned>> getAllDevice(@PathVariable UUID homeId)
    {
        return ResponseEntity.ok(devicesAssignedService.getAllDevice(homeId));
    }
}
