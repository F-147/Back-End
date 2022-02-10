package com.adduser.crud.Repository;

import com.adduser.crud.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LoginRepo extends JpaRepository<Login, Integer>{
    public Login findByEmailId(String emailId);
    public Login findByEmailIdAndPassword(String emailId, String password);
//    public Login findByUsername(String userName);

    @Query("select d from Login d where d.userName = :userName")

    Login findByUsername(@Param("userName") String userName);
    
}
