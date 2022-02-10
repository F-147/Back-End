package com.adduser.crud.service;

import java.util.ArrayList;

import com.adduser.crud.Repository.UserRepository;
import com.adduser.crud.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrudService {
    
    // Injecting the repository
    @Autowired
    private UserRepository repo;
    
    // Local User

    public ArrayList<User> fetchUserFromRepository() {
        return (ArrayList<User>) repo.findAll();
    }

    public User persistUserIntoRepository(User User) {
        return repo.save(User);
    }

    public String updateUserInRepository(User user) {
        try {

            repo.save(user);
            return "User Updated";
        } catch (Exception e) {
            return "There is no User registered under the ID: " + user.getId()
                    + "\nMake sure you you send a valid User!";
        }
    }

    public String deleteUserById(long id) {
        try {
            repo.deleteById(id);
            return "User Deleted Successfully";
        } catch (Exception e) {
            return "User not found";
        }

    }
}
