package com.preeti.assignment2.repository;

import com.preeti.assignment2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,String> {
}
