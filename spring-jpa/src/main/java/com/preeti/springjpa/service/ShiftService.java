package com.preeti.springjpa.service;

import com.preeti.springjpa.entity.Shift;
import com.preeti.springjpa.entity.ShiftType;
import com.preeti.springjpa.entity.Tenant;
import com.preeti.springjpa.repository.IShiftRepository;
import com.preeti.springjpa.repository.IShiftTypeRepository;
import com.preeti.springjpa.repository.ITenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class ShiftService {

    @Autowired
    IShiftRepository shiftRepository;
    @Autowired
    ITenantRepository tenantRepository;
    @Autowired
    IShiftTypeRepository shiftTypeRepository;


    public Shift createShift(Shift shift) {

        Tenant tenant=shift.getTenant();
        Tenant shiftTenant=tenantRepository.getById(tenant.getId());
        shift.setTenant(shiftTenant);
        ShiftType shiftType=shift.getShiftType();
        ShiftType shiftShiftType=shiftTypeRepository.getById(shiftType.getId());
        shift.setShiftType(shiftShiftType);

        return shiftRepository.save(shift);

    }

    public List<Shift> findTop3ShiftByStartDateAndEndDateOrderByNameAsc(LocalDate startDate, LocalDate endDate)
    {
        return shiftRepository.findTop3ByStartDateAndEndDateOrderByNameAsc(startDate, endDate);
    }
}
