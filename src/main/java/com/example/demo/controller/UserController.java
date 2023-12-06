package com.example.demo.controller;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.model.UserRole;
import com.example.demo.payloads.SuccessResponse;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody User user) throws Exception {
        Set<UserRole> userRoles=new HashSet<>();
        Role role=new Role();
        role.setRoleName("USER");
        role.setRoleId(45L);
        UserRole userRole=new UserRole();
        userRole.setRole(role);
        userRole.setUser(user);
        userRoles.add(userRole);
        User user1=userService.createUser(user,userRoles);
        return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }
    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) throws Exception {
        User user = this.userService.getUserByUsername(username);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> users=this.userService.getAllUser();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }
    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable Long userId){
        User user1=this.userService.updateUserById(user,userId);
        return new ResponseEntity<>(user1,HttpStatus.OK);
    }
    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId){
        this.userService.deleteUserById(userId);
        return new ResponseEntity<>("User deleted successfully.",HttpStatus.OK);
    }
}
