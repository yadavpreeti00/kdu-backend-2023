package com.preeti.miniProject.repository;

import com.preeti.miniProject.entity.UserHome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface IUserHomeRepository extends JpaRepository<UserHome, UUID> {
    @Query(value = "SELECT * FROM user_home h WHERE h.user_id = :userId", nativeQuery = true)
    List<UserHome> findAllHomesByUserId(@Param("userId") UUID userId);

    Optional<UserHome> findByUserEntity_IdAndHome_Id(UUID userId, UUID homeId);

}