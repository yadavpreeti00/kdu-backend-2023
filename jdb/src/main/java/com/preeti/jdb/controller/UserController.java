package com.preeti.jdb.controller;

import com.preeti.jdb.entity.User;
import com.preeti.jdb.service.UserDaoImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserDaoImpl userDao;

    @PostMapping("/create")
    public void create(@RequestBody User user) throws SQLException {
        userDao.insert(user);
    }

    @GetMapping("/select")
    public User read(@RequestParam("id") UUID id, @RequestParam("tenant_id") UUID tenantId) throws SQLException {
        return userDao.select(id, tenantId);
    }

    @PutMapping("/update")
    public void update(@RequestBody User user) throws SQLException {
        userDao.update(user);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam("id") UUID id, @RequestParam("tenant_id") UUID tenantId) throws SQLException {
        userDao.delete(id,tenantId);
    }
}
