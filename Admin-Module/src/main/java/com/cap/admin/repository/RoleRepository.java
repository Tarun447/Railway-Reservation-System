package com.cap.admin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cap.admin.model.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
  
	Role findByRole(String role);
	
}
