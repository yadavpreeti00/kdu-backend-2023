package com.preeti.miniProject.controller;

import com.preeti.miniProject.entity.Room;
import com.preeti.miniProject.model.request.AddRoomToHomeRequest;
import com.preeti.miniProject.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/home/room")
public class RoomController {

    @Autowired
    RoomService roomService;
    @PostMapping("/create")
    public ResponseEntity<Room> create(@RequestBody AddRoomToHomeRequest addRoomToHomeRequest)
    {
        return ResponseEntity.ok(roomService.addRoomToHome(addRoomToHomeRequest));
    }

    @GetMapping("/getAll/{homeId}")
    public ResponseEntity<List<Room>> getAllRoom(@PathVariable UUID homeId)
    {
        return ResponseEntity.ok(roomService.getAllRoom(homeId));
    }
}
