package com.preeti.springjpa.controller;

import com.preeti.springjpa.entity.ShiftType;
import com.preeti.springjpa.service.ShiftTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/shift-type")
public class ShiftTypeController {

    @Autowired
    ShiftTypeService shiftTypeService;

    @PostMapping("/create")
    public ResponseEntity<ShiftType> createShiftType(@RequestBody ShiftType shiftType ) {

        ShiftType createdShiftType = shiftTypeService.createShiftType(shiftType);
        return new ResponseEntity<>(createdShiftType, HttpStatus.CREATED);
    }

}
