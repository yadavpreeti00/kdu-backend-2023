package com.preeti.jdb.repository;

import com.preeti.jdb.entity.User;

import java.util.UUID;

public interface IUserDao {
    public void insert(User user);
    public void update(User user);
    public User select(UUID id,UUID tenantId);
    public void delete(UUID id,UUID tenantId);
}
