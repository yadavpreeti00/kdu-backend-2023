package com.preeti.springjpa.service;

import com.preeti.springjpa.entity.Tenant;
import com.preeti.springjpa.exception.TenantNotFoundException;
import com.preeti.springjpa.repository.ITenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TenantService {

    @Autowired
    ITenantRepository tenantRepository;

    public Tenant createTenant(Tenant tenant) {
        return tenantRepository.save(tenant);
    }

    public Tenant getTenantById(UUID id)
    {
        return tenantRepository.findById(id).orElseThrow(() -> new TenantNotFoundException(id));
    }
}
