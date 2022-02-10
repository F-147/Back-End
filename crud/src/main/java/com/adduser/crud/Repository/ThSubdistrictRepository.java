package com.adduser.crud.Repository;

import java.util.List;

import com.adduser.crud.model.ThSubdistrict;

import org.springframework.data.jpa.repository.JpaRepository;



public interface ThSubdistrictRepository extends JpaRepository<ThSubdistrict, Long> {

    List<ThSubdistrict> findByDistrictId(Long districtId);
    
    public ThSubdistrict findById(long id);
    
}
