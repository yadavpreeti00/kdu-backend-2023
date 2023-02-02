package com.preeti.miniProject.repository;

import com.preeti.miniProject.entity.Home;
import com.preeti.miniProject.entity.UserEntity;
import com.preeti.miniProject.entity.UserHome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface IUserHomeRepository extends JpaRepository<UserHome, UUID> {
    Optional<UserHome> findByUserEntity_IdAndHome_Id(UUID userId, UUID homeId);

}