package com.preeti.springjpa.repository;

import com.preeti.springjpa.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ITenantRepository extends JpaRepository<Tenant, UUID> {
}
