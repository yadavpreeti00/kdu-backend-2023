package com.preeti.miniProject.service;


import com.preeti.miniProject.entity.DeviceInventory;
import com.preeti.miniProject.entity.UserDevice;
import com.preeti.miniProject.entity.UserEntity;
import com.preeti.miniProject.exception.DeviceAlreadyPurchasedException;
import com.preeti.miniProject.exception.DevicePasswordNotFoundException;
import com.preeti.miniProject.exception.DeviceUsernameNotFoundException;
import com.preeti.miniProject.model.AddDeviceRequest;
import com.preeti.miniProject.repository.IDeviceInventoryRepository;
import com.preeti.miniProject.repository.IUserDeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserDeviceService {

    @Autowired
    IDeviceInventoryRepository deviceInventoryRepository;
    @Autowired
    UserService userService;
    @Autowired
    IUserDeviceRepository userDeviceRepository;

    /**
     * @param addDeviceRequest adding device to user
     * @return uuid of device added with user
     */
    public UUID addDevice(AddDeviceRequest addDeviceRequest)
    {

        DeviceInventory deviceInventory=deviceInventoryRepository.getReferenceById(addDeviceRequest.getKickstonId());
        if(deviceInventory.getPurchased().equals(true))
        {
            throw new DeviceAlreadyPurchasedException();
        }
//        if(deviceInventory.getDeviceUsername()!= addDeviceRequest.getDeviceUsername())
//        {
//            throw new DeviceUsernameNotFoundException(addDeviceRequest.getDeviceUsername());
//        }
//        if(deviceInventory.getDevicePassword()!= addDeviceRequest.getDevicePassword())
//        {
//            throw new DevicePasswordNotFoundException(addDeviceRequest.getDevicePassword());
//        }
        deviceInventory=deviceInventoryRepository.getReferenceById(addDeviceRequest.getKickstonId());
        deviceInventory.setPurchased(true);
        deviceInventoryRepository.save(deviceInventory);

        String authenticatedUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity authenticatedUser = userService.getUserFromUsername(authenticatedUsername);

        var userDevice= UserDevice.builder()
                .deviceInventory(deviceInventory)
                .userEntity(authenticatedUser)
                .build();

        userDeviceRepository.save(userDevice);

        return deviceInventory.getKickstonId();

    }


}
