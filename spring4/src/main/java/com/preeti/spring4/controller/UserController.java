package com.preeti.spring4.controller;




import com.preeti.spring4.entity.User;
import com.preeti.spring4.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth/get")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/all")
    public List<User> all()
    {
        return userRepository.getAll();
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable String username)
    {
        return userRepository.findByFirstName(username);
    }
}
