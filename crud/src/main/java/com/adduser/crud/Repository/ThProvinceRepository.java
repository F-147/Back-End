package com.adduser.crud.Repository;

import com.adduser.crud.model.ThProvince;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ThProvinceRepository extends JpaRepository<ThProvince, Long> {

    public ThProvince findById(long id);  
    
}
