package com.adduser.crud.controller;

import java.util.ArrayList;

import com.adduser.crud.model.User;
import com.adduser.crud.service.CrudService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrudRestController {

    // Injecting the service
    @Autowired
    private CrudService service;

    ArrayList<User> user;

    @GetMapping("/getUserlist")
    @CrossOrigin(origins = "http://localhost:4200")
    public ArrayList<User> fetchUserList() {
        // Logic to fetch list from database
        user = new ArrayList<User>();
        user = service.fetchUserFromRepository();
        return user;
    }

    @PostMapping("/addUser")
    @CrossOrigin(origins = "http://localhost:4200")
    public User saveUser(@RequestBody User user) {
        // Logic to save the User into database
        return service.persistUserIntoRepository(user);
    }

    @PostMapping("/editUser")
    @CrossOrigin(origins = "http://localhost:4200")
    public String updateUser(@RequestBody User User) {
        // Logic to get update User from database
        return service.updateUserInRepository(User);
    }

    @DeleteMapping("/deleteUser/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity deleteUser(@PathVariable long id) {
        // Logic to get delete User by id from database

        service.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    
    

}
