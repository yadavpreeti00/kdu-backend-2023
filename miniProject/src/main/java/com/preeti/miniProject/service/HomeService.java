package com.preeti.miniProject.service;

import com.preeti.miniProject.entity.Home;
import com.preeti.miniProject.entity.UserEntity;
import com.preeti.miniProject.exception.HomeNotFoundException;
import com.preeti.miniProject.repository.IHomeRepository;
import com.preeti.miniProject.repository.IUserHomeRepository;
import com.preeti.miniProject.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HomeService {


    private final IHomeRepository homeRepository;



    public Home getHomeFromId(UUID id)
    {
        if(!homeRepository.existsById(id))
        {
            throw new HomeNotFoundException(id);
        }
        return homeRepository.getReferenceById(id);
    }
}
