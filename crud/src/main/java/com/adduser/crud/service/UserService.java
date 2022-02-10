package com.adduser.crud.service;

import com.adduser.crud.model.Login;

import java.util.List;

import com.adduser.crud.Repository.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private LoginRepo repo;

    public List<Login> findAll(){
        return repo.findAll();
    }

    public Login saveUser(Login login) {
        return repo.save(login);
    }

    public Login fetchUserByEmailId(String email) {
        return repo.findByEmailId(email);
    }

    public Login fetchUserByEmailIdAndPassword(String email, String password) {
        return repo.findByEmailIdAndPassword(email,password);
    }
}