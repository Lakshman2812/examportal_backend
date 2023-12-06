package com.example.demo.service.ServiceImpl;

import com.example.demo.Exception.ResourceFoundException;
import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.model.User;
import com.example.demo.model.UserRole;
import com.example.demo.repo.RoleRepo;
import com.example.demo.repo.UserRepo;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleRepo roleRepo;
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {
        User exitUser=this.userRepo.findByUsername(user.getUsername());
        if(exitUser!=null){
            throw new Exception(new ResourceFoundException("Username",user.getUsername()));
        }
        exitUser=this.userRepo.findByEmail(user.getEmail());
        if(exitUser!=null){
            throw new Exception(new ResourceFoundException("Email",user.getUsername()));
        }
        exitUser=this.userRepo.findByPhone(user.getPhone());
        if(exitUser!=null){
            throw new Exception(new ResourceFoundException("Mobile Number",user.getPhone()));
        }
        for (UserRole ur:userRoles){
            roleRepo.save(ur.getRole());
        }
        user.getUserRoles().addAll(userRoles);
        return this.userRepo.save(user);
    }

    @Override
    public User getUserByUsername(String username) throws Exception {
        User exitUser=this.userRepo.findByUsername(username);
        if(exitUser==null){
            throw new Exception(new ResourceNotFoundException("Username",username));
        }
        return exitUser;
    }

    @Override
    public List<User> getAllUser() {
        return this.userRepo.findAll();
    }

    @Override
    public User updateUserById(User user, Long userId) {
        User existUser=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("UserId",userId.toString()));
        existUser.setFirstName(user.getFirstName());
        existUser.setLastName(user.getLastName());
        existUser.setPhone(user.getPhone());
        existUser.setEmail(user.getEmail());
        existUser.setUsername(user.getUsername());
        return this.userRepo.save(existUser);
    }

    @Override
    public void deleteUserById(Long id) {
        User existUser=this.userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("UserId",id.toString()));
         this.userRepo.delete(existUser);
    }
}
