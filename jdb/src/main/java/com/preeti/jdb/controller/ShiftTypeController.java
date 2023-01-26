package com.preeti.jdb.controller;

import com.preeti.jdb.model.ShiftType;
import com.preeti.jdb.service.ShiftTypeDaoImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/shift-type")
@RequiredArgsConstructor
public class ShiftTypeController {

    private final ShiftTypeDaoImpl shiftTypeDao;

    @GetMapping("/select")
    public ShiftType getShiftType(@RequestParam("id") UUID id, @RequestParam("tenant_id") UUID tenantId) {
        return shiftTypeDao.getShiftType(id, tenantId);
    }

    @PostMapping("/create")
    public ShiftType createShiftType(@RequestBody ShiftType shiftType) {
        return shiftTypeDao.createShiftType(shiftType);
    }

}
