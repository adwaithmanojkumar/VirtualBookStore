package com.springprojects.virtualbookstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springprojects.virtualbookstore.model.Address;

public interface AddressRepo extends JpaRepository<Address, Long>{
	
}
