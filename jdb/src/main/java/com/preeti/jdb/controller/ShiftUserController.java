package com.preeti.jdb.controller;

import com.preeti.jdb.entity.ShiftUser;
import com.preeti.jdb.service.ShiftUserDaoImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/shift_user")
@RequiredArgsConstructor
public class ShiftUserController {

    private final ShiftUserDaoImpl shiftUserDao;


    @PostMapping("/create")
    public ShiftUser createShiftUser(@RequestBody ShiftUser shiftUser) {
        return shiftUserDao.createShiftUser(shiftUser);
    }

    @GetMapping("/select")
    public ShiftUser selectShiftUser(@RequestParam("id") UUID id, @RequestParam("tenant_id") UUID tenantId) {
        return shiftUserDao.selectShiftUser(id,tenantId);
    }
}