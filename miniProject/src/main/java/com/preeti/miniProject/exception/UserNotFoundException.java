package com.preeti.miniProject.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;

import java.util.UUID;

@Slf4j
public class UserNotFoundException extends RuntimeException {

        public UserNotFoundException(UUID id)
        {
            super(String.format("User with id %s not found", id));
            log.info("User with username "+id+" not found");
        }
        public UserNotFoundException(String username)
        {
            super(String.format("User with username %s not found", username));
            log.info("User with username "+username+" not found");
        }

}
