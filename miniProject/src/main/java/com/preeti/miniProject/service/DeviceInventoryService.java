package com.preeti.miniProject.service;

import com.preeti.miniProject.entity.DeviceInventory;
import com.preeti.miniProject.repository.IDeviceInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceInventoryService {

    @Autowired
    IDeviceInventoryRepository deviceInventoryRepository;
    public DeviceInventory createDevice(DeviceInventory device)
    {
        return deviceInventoryRepository.save(device);
    }
}
