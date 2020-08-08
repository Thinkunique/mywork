package com.online.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.online.model.Car;

public interface CarRepository extends MongoRepository<Car, String>{

}
