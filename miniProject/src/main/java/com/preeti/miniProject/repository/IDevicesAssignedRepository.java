package com.preeti.miniProject.repository;

import com.preeti.miniProject.entity.DevicesAssigned;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IDevicesAssignedRepository extends JpaRepository<DevicesAssigned, UUID> {
}