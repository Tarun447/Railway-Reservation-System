package com.cap.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cap.model.Role;

public interface RoleRepository extends MongoRepository<Role, Long> {
  
	Role findByRole(String role);
	
}
