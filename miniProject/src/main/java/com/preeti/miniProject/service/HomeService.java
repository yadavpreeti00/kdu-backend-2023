package com.preeti.miniProject.service;

import com.preeti.miniProject.entity.Home;
import com.preeti.miniProject.exception.HomeNotFoundException;
import com.preeti.miniProject.repository.IHomeRepository;
import lombok.RequiredArgsConstructor;
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

    public Home updateAddress(String address, UUID homeId) {
        var home=homeRepository.getReferenceById(homeId);
        home.setAddress(address);
        return homeRepository.save(home);
    }
}
