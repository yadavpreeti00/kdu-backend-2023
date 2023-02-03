package com.preeti.miniProject.repository;

import com.preeti.miniProject.entity.DeviceInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IDeviceInventoryRepository extends JpaRepository<DeviceInventory, UUID> {
}
