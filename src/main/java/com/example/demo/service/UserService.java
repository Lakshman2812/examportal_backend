package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.model.UserRole;

import java.util.List;
import java.util.Set;

public interface UserService {
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;
    public User getUserByUsername(String username) throws Exception;
    public List<User> getAllUser();
    public User updateUserById(User user,Long userId);
    public void deleteUserById(Long id);

}
