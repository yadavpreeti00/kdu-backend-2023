package com.preeti.miniProject.service;

import com.preeti.miniProject.entity.Room;
import com.preeti.miniProject.entity.UserEntity;
import com.preeti.miniProject.entity.UserHome;
import com.preeti.miniProject.exception.AdminRoleNotFoundException;
import com.preeti.miniProject.exception.UserNotFoundException;
import com.preeti.miniProject.model.AddRoomToHomeRequest;
import com.preeti.miniProject.model.AddUserToHomeRequest;
import com.preeti.miniProject.repository.IHomeRepository;
import com.preeti.miniProject.repository.IRoomRepository;
import com.preeti.miniProject.repository.IUserHomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    @Autowired
    UserService userService;
    @Autowired
    IUserHomeRepository userHomeRepository;
    @Autowired
    IHomeRepository homeRepository;
    @Autowired
    IRoomRepository roomRepository;
    public Room addRoomToHome(AddRoomToHomeRequest addRoomToHomeRequest) {
        String authenticatedUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity authenticatedUser = userService.getUserFromUsername(authenticatedUsername);
        var home=homeRepository.getReferenceById(addRoomToHomeRequest.getHomeId());

        var userHome=userHomeRepository.findByUserEntity_IdAndHome_Id(authenticatedUser.getId(),home.getId()).orElseThrow(() -> new UserNotFoundException(authenticatedUser.getId()));
        boolean isAdmin= userHome.getIsAdmin();
        if(! isAdmin)
        {
            throw new AdminRoleNotFoundException(authenticatedUser.getUsername());
        }
        var room=Room.builder()
                .name(addRoomToHomeRequest.getName())
                .home(home)
                .build();

        return roomRepository.save(room);
    }

}
