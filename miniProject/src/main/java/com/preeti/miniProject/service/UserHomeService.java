package com.preeti.miniProject.service;

import com.preeti.miniProject.entity.Home;
import com.preeti.miniProject.entity.UserEntity;
import com.preeti.miniProject.entity.UserHome;
import com.preeti.miniProject.exception.AdminRoleNotFoundException;
import com.preeti.miniProject.exception.UserNotFoundException;
import com.preeti.miniProject.model.AddUserToHomeRequest;
import com.preeti.miniProject.repository.IHomeRepository;
import com.preeti.miniProject.repository.IUserHomeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

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

//    public List<UserHome> getAllUsersOfHome(Home home) {
//        return entityManager.createQuery("SELECT uh FROM UserHome uh WHERE uh.home = :home", UserHome.class)
//                .setParameter("home", home)
//                .getResultList();
//    }

//    public Boolean isAdmin(UserEntity authenticatedUser, Home home) {
//
//        List<UserHome> homeUsers=getAllUsersOfHome(home);
//
//        for(UserHome homeUser:homeUsers)
//        {
//            log.info(homeUser.toString());
//            if((homeUser.getUserEntity().getId().equals(authenticatedUser.getId()))
//                    && homeUser.getIsAdmin())
//            {
//                return true;
//            }
//        }
//        return false;
//    }




    public UUID addUser(AddUserToHomeRequest addUserToHomeRequest)
    {
        String authenticatedUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity authenticatedUser = userService.getUserFromUsername(authenticatedUsername);
        var user=userService.getUserFromId(addUserToHomeRequest.getUserId());
        var home=homeService.getHomeFromId(addUserToHomeRequest.getHomeId());

        var userHome=userHomeRepository.findByUserEntity_IdAndHome_Id(authenticatedUser.getId(),home.getId()).orElseThrow(() -> new UserNotFoundException(authenticatedUser.getId()));
        boolean isAdmin= userHome.getIsAdmin();

        //Boolean isAdmin=isAdmin(authenticatedUser,home);


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
}
