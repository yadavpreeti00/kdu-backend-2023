package com.preeti.springjpa.repository;

import com.preeti.springjpa.entity.ShiftUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IShiftUserRepository extends JpaRepository<ShiftUser, UUID> {
}
