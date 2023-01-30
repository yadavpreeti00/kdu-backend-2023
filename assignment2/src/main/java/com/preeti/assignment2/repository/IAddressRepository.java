package com.preeti.assignment2.repository;

import com.preeti.assignment2.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAddressRepository extends JpaRepository<Address,String> {
    List<Address> findAllByUserUsername(String username);
}
