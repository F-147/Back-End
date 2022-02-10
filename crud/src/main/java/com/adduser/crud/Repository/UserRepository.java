package com.adduser.crud.Repository;

import java.util.List;

import com.adduser.crud.model.User;

import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Long >{
    
    public List<User> findAll();

    public List<User> findById(int id);
}
