package com.preeti.springjpa.controller;


import com.preeti.springjpa.entity.User;
import com.preeti.springjpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/user")

public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<User>updateUser(@PathVariable("id") UUID id, @RequestBody User user)
    {
        User existingUser=userService.getUserById(id);
        User updatedUser=userService.updateUser(user,existingUser);

        return new ResponseEntity<>(updatedUser, HttpStatus.CREATED);
    }

    @GetMapping("/findAll")
    public ResponseEntity<Page<User>> findAllUsers(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "50") int size) {

        Page<User> usersPage = userService.findAllUsers(page, size);

        if(usersPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(usersPage, HttpStatus.OK);
    }




}
