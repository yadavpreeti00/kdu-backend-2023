package com.preeti.miniProject.service;

import com.preeti.miniProject.entity.UserEntity;
import com.preeti.miniProject.exception.UserNotFoundException;
import com.preeti.miniProject.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {


    private final IUserRepository userRepository;

    public void addUser(UserEntity userEntity)
    {
        userRepository.save(userEntity);
    }

    public UserEntity getUserFromUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(()-> new UserNotFoundException(username));
    }
    public UserEntity getUserFromId(UUID id) {
        return userRepository.findById(id).orElseThrow(()-> new UserNotFoundException(id));
    }
}
