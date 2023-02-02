package com.preeti.miniProject.exception;

import com.preeti.miniProject.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AdminRoleNotFoundException extends RuntimeException {
    public AdminRoleNotFoundException(String username) {
        super(String.format("User with username %s id not the admin of house.", username));
        log.info("User with username "+username+" id not the admin of house.");
    }
}
