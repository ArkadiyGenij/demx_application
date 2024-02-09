package com.example.demoex.repo;

import com.example.demoex.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {
    List<User> findByNameContainingIgnoreCase(String name);
}
