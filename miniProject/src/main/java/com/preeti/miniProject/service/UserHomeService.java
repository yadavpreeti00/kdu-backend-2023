package com.preeti.miniProject.service;

import com.preeti.miniProject.entity.Home;
import com.preeti.miniProject.entity.UserEntity;
import com.preeti.miniProject.entity.UserHome;
import com.preeti.miniProject.exception.AdminRoleNotFoundException;
import com.preeti.miniProject.exception.UserNotFoundException;
import com.preeti.miniProject.model.request.AddUserToHomeRequest;
import com.preeti.miniProject.repository.IHomeRepository;
import com.preeti.miniProject.repository.IUserHomeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserHomeService {



    private final IUserHomeRepository userHomeRepository;

    private final UserService userService;

    private final HomeService homeService;


    private final IHomeRepository homeRepository;
    @PersistenceContext
    private EntityManager entityManager;

    public UserHome addUserHomeAdmin(Home home) {

        String authenticatedUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity authenticatedUser = userService.getUserFromUsername(authenticatedUsername);
        Home createdHome=homeRepository.save(home);
        var userHomeAdmin=UserHome.builder()
                .home(home)
                .userEntity(authenticatedUser)
                .isAdmin(true)
                .build();
        userHomeRepository.save(userHomeAdmin);
        return userHomeAdmin;
    }

    public UUID addUser(AddUserToHomeRequest addUserToHomeRequest)
    {
        String authenticatedUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity authenticatedUser = userService.getUserFromUsername(authenticatedUsername);
        var user=userService.getUserFromId(addUserToHomeRequest.getUserId());
        var home=homeService.getHomeFromId(addUserToHomeRequest.getHomeId());

        var userHome=userHomeRepository.findByUserEntity_IdAndHome_Id(authenticatedUser.getId(),home.getId()).orElseThrow(() -> new UserNotFoundException(authenticatedUser.getId()));
        boolean isAdmin= userHome.getIsAdmin();



        if(! isAdmin)
        {
            throw new AdminRoleNotFoundException(authenticatedUser.getUsername());
        }
        var homeBasicUser=UserHome.builder()
                .home(home)
                .userEntity(user)
                .isAdmin(false)
                .build();
         userHomeRepository.save(homeBasicUser);
         return home.getId();
    }

    public List<UserHome> listAllHome(UUID id) {
        String authenticatedUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity authenticatedUser = userService.getUserFromUsername(authenticatedUsername);

        if(!authenticatedUser.getId().equals(id))
        {
            throw new RuntimeException();
        }
        log.info("listAllHome");
        return userHomeRepository.findAllHomesByUserId(id);
    }
}
