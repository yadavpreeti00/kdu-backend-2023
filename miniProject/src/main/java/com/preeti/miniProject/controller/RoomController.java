package com.preeti.miniProject.controller;

import com.preeti.miniProject.entity.Home;
import com.preeti.miniProject.entity.Room;
import com.preeti.miniProject.entity.UserHome;
import com.preeti.miniProject.model.AddRoomToHomeRequest;
import com.preeti.miniProject.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
