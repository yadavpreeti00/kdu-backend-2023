package com.preeti.miniProject.repository;

import com.preeti.miniProject.entity.UserDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IUserDeviceRepository extends JpaRepository<UserDevice, UUID> {
}