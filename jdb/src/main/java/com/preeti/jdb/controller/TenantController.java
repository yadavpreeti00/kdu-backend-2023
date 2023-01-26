package com.preeti.jdb.controller;

import com.preeti.jdb.entity.Tenant;
import com.preeti.jdb.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tenant")
@RequiredArgsConstructor
public class TenantController {

    private final TenantDaoImpl tenantDao;

    @PostMapping("/save")
    public void saveTenantEntities(@RequestBody Tenant tenant) {
        tenantDao.createTenant(tenant);
    }
}