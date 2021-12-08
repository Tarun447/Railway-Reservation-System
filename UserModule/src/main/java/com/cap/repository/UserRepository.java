package com.cap.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cap.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	User findByUserName(String username);
}
