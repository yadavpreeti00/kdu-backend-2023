package com.preeti.springjpa.service;

import com.preeti.springjpa.entity.Shift;
import com.preeti.springjpa.entity.ShiftUser;
import com.preeti.springjpa.entity.Tenant;
import com.preeti.springjpa.entity.User;
import com.preeti.springjpa.exception.BadRequestException;
import com.preeti.springjpa.exception.ShiftUserNotFoundException;
import com.preeti.springjpa.repository.IShiftRepository;
import com.preeti.springjpa.repository.IShiftUserRepository;
import com.preeti.springjpa.repository.ITenantRepository;
import com.preeti.springjpa.repository.IUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.UUID;

@Service
@Slf4j
public class ShiftUserService {

    @Autowired
    IShiftUserRepository shiftUserRepository;
    @Autowired
    IShiftRepository shiftRepository;

    @Autowired
    IUserRepository userRepository;
    @Autowired
    ITenantRepository tenantRepository;

    public ShiftUser createShiftUser(ShiftUser shiftUser)
    {
        log.info(shiftUser.toString());
        log.info(String.valueOf(shiftUser.getUser().toString()));
        log.info(String.valueOf(shiftUser.getShift().toString()));
        log.info(String.valueOf(shiftUser.getTenant().toString()));

        User user=shiftUser.getUser();
        User userFetched=userRepository.getById(user.getId());
        shiftUser.setUser(userFetched);

        Tenant tenant=shiftUser.getTenant();
        Tenant shiftTenant=tenantRepository.getById(tenant.getId());
        shiftUser.setTenant(shiftTenant);

        Shift shift=shiftUser.getShift();
        Shift shiftUSershift=shiftRepository.getById(shift.getId());
        shiftUser.setShift(shiftUSershift);



        return shiftUserRepository.save(shiftUser);
    }


    public ShiftUser getShiftUser(UUID id)
    {
        return shiftUserRepository.findById(id).orElseThrow(() -> new ShiftUserNotFoundException(id));
    }

    public void deleteShiftUserByEndTime(UUID id,Shift shift, Time endTime) {

        log.info(String.valueOf(endTime));
        log.info(String.valueOf(shift.getTimeEnd()));
        if(shift.getTimeEnd().equals(endTime))
        {
            shiftUserRepository.deleteById(id);
        }
        else
        {
            throw new BadRequestException(endTime);
        }
    }

    public void deleteShiftUser(UUID id) {
        shiftUserRepository.deleteById(id);
    }
}
