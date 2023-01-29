package com.preeti.springjpa.controller;

import com.preeti.springjpa.entity.Shift;
import com.preeti.springjpa.entity.ShiftUser;
import com.preeti.springjpa.service.ShiftUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;

import java.util.UUID;

@RestController
@RequestMapping("/shift-user")
@Slf4j
public class ShiftUserController {

    @Autowired
    ShiftUserService shiftUserService;


    @PostMapping("/create")
    public ResponseEntity<ShiftUser> createShiftUser(@RequestBody ShiftUser shiftUser)
    {
        log.info(shiftUser.toString());
        ShiftUser createdUser = shiftUserService.createShiftUser(shiftUser);
        return new ResponseEntity<>(createdUser, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ShiftUser> deleteShiftUser(@RequestParam("id") UUID id)
    {
        shiftUserService.deleteShiftUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete-by-end-time/{id}")
    public ResponseEntity<Void> deleteShiftUserByEndTime(@PathVariable("id") UUID id)
    {
        ShiftUser shiftUser=shiftUserService.getShiftUser(id);
        Shift shift=shiftUser.getShift();
        Time time= Time.valueOf("23:00:00");
        shiftUserService.deleteShiftUserByEndTime(id,shift,time);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
