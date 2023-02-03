package com.preeti.miniProject.service;

import com.preeti.miniProject.entity.DevicesAssigned;
import com.preeti.miniProject.repository.IDevicesAssignedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DevicesAssignedService {
    @Autowired
    IDevicesAssignedRepository devicesAssignedRepository;
    public List<DevicesAssigned> getAllDevice(UUID homeId) {
        return devicesAssignedRepository.findByHome_Id(homeId);
    }
}
