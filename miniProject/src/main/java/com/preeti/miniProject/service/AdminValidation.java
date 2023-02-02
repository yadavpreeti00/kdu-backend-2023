package com.preeti.miniProject.service;

import com.preeti.miniProject.entity.Home;
import com.preeti.miniProject.entity.UserEntity;
import com.preeti.miniProject.entity.UserHome;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminValidation {

//    @Autowired
//    UserHomeService userHomeService;
//    public Boolean isAdmin(UserEntity authenticatedUser, Home home) {
//
//        List<UserHome> homeUsers=userHomeService.getAllUsersOfHome(home);
//        for(UserHome homeUser:homeUsers)
//        {
//            if((homeUser.getUserEntity().getId().equals(authenticatedUser.getId()))
//                && homeUser.getIsAdmin())
//            {
//                return true;
//            }
//        }
//        return false;
//    }
}
