package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserRepository;
import com.model.Users;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Users saveUser(Users user) {
        return userRepository.save(user);
    }
    
    public Users getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }
    public Users getUserByName(String name) {
        return userRepository.getUserByName(name);
    }
    
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public Users updateUser(int id, Users updatedUser) {
        Users existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setPassword(updatedUser.getPassword());
            existingUser.setEmail(updatedUser.getEmail());

            return userRepository.save(existingUser);
        }

        return null;
    }
    public void deleteUser(int id) {
    	Users existingUser=userRepository.findById(id).orElse(null);
        userRepository.delete(existingUser);
    }
}

