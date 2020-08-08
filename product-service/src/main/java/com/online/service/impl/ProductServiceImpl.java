package com.online.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import com.online.model.Car;
import com.online.model.User;
import com.online.repository.CarRepository;
import com.online.response.ProductResponse;
import com.online.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	CarRepository repository;

	@Override
	public ProductResponse addNewCar(Car car) {
		ProductResponse response = new ProductResponse();
		repository.save(car);
		response.setCode("200");
		response.setMessage("car added successfully");
		return response;
	}

	@Override
	public List<Car> retrieveCars(User seller) {
		Car car = new Car();
		car.setSeller(seller);
		Example<Car> example = Example.of(car);
		Iterable<Car> list = repository.findAll(example);
		List<Car> responseList = new LinkedList<>();
		for (Car details : list) {
			responseList.add(details);
		}
		return responseList;
	}

}
