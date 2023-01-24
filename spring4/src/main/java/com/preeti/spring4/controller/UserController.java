package com.preeti.spring4.controller;




import com.preeti.spring4.entity.User;
import com.preeti.spring4.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/getAll")
    public List<User> getAll()
    {
       // return ResponseEntity.ok(userRepository.getAll()).getBody();
        return userRepository.getAll();
    }
}
