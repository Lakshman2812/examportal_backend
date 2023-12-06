package com.example.demo.repo;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {
    public User findByUsername(String username);
    public User findByEmail(String email);
    public User findByPhone(String phone);
}
