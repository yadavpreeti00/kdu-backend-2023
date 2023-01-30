package com.preeti.assignment2.repository;

import com.preeti.assignment2.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IOrderRepository extends JpaRepository<Order, UUID> {
    List<Order> findAllByUserUsername(String username);
}
