package com.preeti.assignment2.repository;

import com.preeti.assignment2.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ICartRepository extends JpaRepository<Cart, UUID> {
    Cart findByUserUsername(String username);
}
