package com.online.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.online.model.CarPhoto;

public interface PhotoRepository extends MongoRepository<CarPhoto, String> { 
	
	
}
