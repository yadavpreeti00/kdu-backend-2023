package com.preeti.miniProject.repository;

import com.preeti.miniProject.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IRoomRepository extends JpaRepository<Room, UUID> {
    List<Room> findByHome_Id(UUID id);
}