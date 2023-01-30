package com.preeti.springjpa.service;

import com.preeti.springjpa.entity.ShiftType;
import com.preeti.springjpa.entity.Tenant;
import com.preeti.springjpa.repository.IShiftTypeRepository;
import com.preeti.springjpa.repository.ITenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShiftTypeService {

    @Autowired
    IShiftTypeRepository shiftTypeRepository;
    @Autowired
    ITenantRepository tenantRepository;
    public ShiftType createShiftType(ShiftType shiftType)
    {
        Tenant tenant=shiftType.getTenant();
        Tenant shiftTenant=tenantRepository.getReferenceById(tenant.getId());
        shiftType.setTenant(shiftTenant);
        return shiftTypeRepository.save(shiftType );
    }
}
