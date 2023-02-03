package com.preeti.miniProject.service;


import com.preeti.miniProject.entity.*;
import com.preeti.miniProject.exception.*;
import com.preeti.miniProject.model.request.AddDeviceRequest;
import com.preeti.miniProject.model.request.AddDeviceToHomeRequest;
import com.preeti.miniProject.model.request.MoveDeviceWithinHomeRequest;
import com.preeti.miniProject.repository.IDeviceInventoryRepository;
import com.preeti.miniProject.repository.IDevicesAssignedRepository;
import com.preeti.miniProject.repository.IUserDeviceRepository;
import com.preeti.miniProject.repository.IUserHomeRepository;
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
    @Autowired
    HomeService homeService;
    @Autowired
    RoomService roomService;
    @Autowired
    IUserHomeRepository userHomeRepository;
    @Autowired
    IDevicesAssignedRepository devicesAssignedRepository;

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


    public UUID addDeviceToHome(AddDeviceToHomeRequest addDeviceToHomeRequest)
    {
        DeviceInventory device=deviceInventoryRepository.getReferenceById(addDeviceToHomeRequest.getKickstonId());
        String authenticatedUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity authenticatedUser = userService.getUserFromUsername(authenticatedUsername);
        Home home=homeService.getHomeFromId(addDeviceToHomeRequest.getHomeId());
        Room room=roomService.getRoomFromId(addDeviceToHomeRequest.getRoomId());

        var userHome=userHomeRepository.findByUserEntity_IdAndHome_Id(authenticatedUser.getId(),home.getId()).orElseThrow(() -> new UserNotFoundException(authenticatedUser.getId()));
        boolean isAdmin= userHome.getIsAdmin();
        if(! isAdmin)
        {
            throw new AdminRoleNotFoundException(authenticatedUser.getUsername());
        }

        UUID homeId=room.getHome().getId();
        if(homeId!=home.getId())
        {
            throw new RoomNotFoundException(room.getId());
        }

        var deviceAssigned=DevicesAssigned.builder()
                .home(home)
                .room(room)
                .deviceInventory(device)
                .build();

        devicesAssignedRepository.save(deviceAssigned);

         return device.getKickstonId();

    }

    public UUID moveDeviceToHome(MoveDeviceWithinHomeRequest moveDeviceWithinHomeRequest) {

        DeviceInventory device=deviceInventoryRepository.getReferenceById(moveDeviceWithinHomeRequest.getKickstonId());
        String authenticatedUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity authenticatedUser = userService.getUserFromUsername(authenticatedUsername);
        Home home=homeService.getHomeFromId(moveDeviceWithinHomeRequest.getHomeId());
        Room room=roomService.getRoomFromId(moveDeviceWithinHomeRequest.getRoomId());

        var userHome=userHomeRepository.findByUserEntity_IdAndHome_Id(authenticatedUser.getId(),home.getId()).orElseThrow(() -> new UserNotFoundException(authenticatedUser.getId()));

        boolean isAdmin= userHome.getIsAdmin();
        if(! isAdmin)
        {
            throw new AdminRoleNotFoundException(authenticatedUser.getUsername());
        }

        UUID homeId=room.getHome().getId();
        if(homeId!=home.getId())
        {
            throw new RoomNotFoundException(room.getId());
        }

        var devicesAssigned=devicesAssignedRepository.findByDeviceInventory_KickstonId(moveDeviceWithinHomeRequest.getKickstonId()).orElseThrow();

        devicesAssigned.setHome(home);
        devicesAssigned.setRoom(room);
        devicesAssignedRepository.save(devicesAssigned);

        return device.getKickstonId();
    }
}
