package com.preeti.springjpa.service;

import com.preeti.springjpa.entity.Tenant;
import com.preeti.springjpa.entity.User;
import com.preeti.springjpa.exception.UserNotFoundException;
import com.preeti.springjpa.repository.ITenantRepository;
import com.preeti.springjpa.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private ITenantRepository tenantRepository;

    public User createUser(User user)
    {
        Tenant tenant=user.getTenant();
        tenant=tenantRepository.getReferenceById(tenant.getId());
        user.setTenant(tenant);
        return userRepository.save(user);
    }

    public Page<User> findAllUsers(int page, int size)
    {
        if (page < 0)
        {
            page = 0;
        }
        if (size < 1 || size > 50) {
            size = 50;
        }

        Pageable pageable = PageRequest.of(page, size);
        return userRepository.findAll(pageable);
    }

    public User getUserById(UUID id)
    {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public User updateUser(User user, User existingUser) {

        Tenant tenant=user.getTenant();
        tenant=tenantRepository.getById(tenant.getId());

        existingUser.setTenant(tenant);
        existingUser.setUsername(user.getUsername());
        existingUser.setLoggedin(user.getLoggedin());
        existingUser.setTimeZone(user.getTimeZone());

        return userRepository.save(existingUser);
    }
}
