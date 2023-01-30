package com.preeti.springjpa.controller;

import com.preeti.springjpa.entity.Shift;
import com.preeti.springjpa.service.ShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/shift")
public class ShiftController {

    @Autowired
    ShiftService shiftService;

    @PostMapping("/create")
    public ResponseEntity<Shift> createShift(@RequestBody Shift shift ) {
        Shift createdShift=shiftService.createShift(shift);

        return new ResponseEntity<>(createdShift, HttpStatus.CREATED);
    }

    @GetMapping("/top-three")
    public List<Shift> getTopShifts() {
        LocalDate startDate = LocalDate.parse("01-Jan-2023", DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
        LocalDate endDate = LocalDate.parse("25-Jan-2023", DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
        return shiftService.findTop3ShiftByStartDateAndEndDateOrderByNameAsc(startDate, endDate);
    }
}
