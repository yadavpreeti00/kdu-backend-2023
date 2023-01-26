package com.preeti.jdb.controller;

import com.preeti.jdb.model.Shift;
import com.preeti.jdb.service.ShiftDaoImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/shift")
@RequiredArgsConstructor
public class ShiftController {

    private final ShiftDaoImpl shiftDao;

    @PostMapping("/create")
    public Shift createShift(@RequestBody Shift shift) {
        return shiftDao.createShift(shift);
    }

    @GetMapping("/select")
    public Shift selectShift(@RequestParam("id") UUID id, @RequestParam("tenant_id") UUID tenantId) {
        return shiftDao.selectShift(id,tenantId);
    }
}