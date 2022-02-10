package com.adduser.crud.Repository;

import com.adduser.crud.model.Address;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
    
    public List<Address> findAll();

    public Address findById(long id);

}
