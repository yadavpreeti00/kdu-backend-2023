package com.preeti.springjpa.controller;


import com.preeti.springjpa.entity.Tenant;
import com.preeti.springjpa.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/tenant")

public class TenantController {
    @Autowired
    TenantService tenantService;

    @PostMapping("/create")
    public ResponseEntity<Tenant> createTenant(@RequestBody Tenant tenant) {
        Tenant createdTenant = tenantService.createTenant(tenant);
        return new ResponseEntity<>(createdTenant, HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<Tenant> getTenantById(@RequestParam("id") UUID id) {
        Tenant tenant=tenantService.getTenantById(id);
        return new ResponseEntity<>(tenant, HttpStatus.OK);
    }

}
