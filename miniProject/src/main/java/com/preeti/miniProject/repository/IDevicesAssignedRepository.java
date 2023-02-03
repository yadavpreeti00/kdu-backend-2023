package com.preeti.miniProject.repository;

import com.preeti.miniProject.entity.DevicesAssigned;
import com.preeti.miniProject.entity.Home;
import com.preeti.miniProject.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface IDevicesAssignedRepository extends JpaRepository<DevicesAssigned, UUID> {
    Optional<DevicesAssigned> findByDeviceInventory_KickstonId(UUID kickstonId);

    List<DevicesAssigned> findByHome_Id(UUID id);

}