package com.adduser.crud.Repository;

import com.adduser.crud.model.AddressType;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressTypeRepository extends JpaRepository <AddressType, Long> {
  
}
