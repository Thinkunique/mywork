package com.online.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.online.model.User;

@Repository
public interface UserRepository extends MongoRepository<User,String>{

	List<User> findByRole(String role);

	
}