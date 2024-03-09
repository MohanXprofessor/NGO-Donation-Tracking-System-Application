package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.model.Users;
import com.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")

@CrossOrigin(origins = "http://localhost:4200")

public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Users> saveUser(@RequestBody Users user) {
        Users savedUser = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).header("Save", "User saved").body(savedUser);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Users>> getAllUsers() {
        List<Users> users = userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    //grtByUserId
    @GetMapping("getUser/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable int id) {
        Users user = userService.getUserById(id);
        return user != null
                ?  ResponseEntity.status(HttpStatus.OK).body(user)
                :  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    	//getByUserName
    @GetMapping("getUser/{name}")
    public ResponseEntity<Users> getUserByName(@PathVariable String name) {
        Users user = userService.getUserByName(name);
        return user != null
                ?  ResponseEntity.status(HttpStatus.OK).body(user)
                :  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable int id, @RequestBody Users updatedUser) {
        Users user = userService.updateUser(id, updatedUser);
        return user != null
        		?  ResponseEntity.status(HttpStatus.OK).body(user)
                :  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
