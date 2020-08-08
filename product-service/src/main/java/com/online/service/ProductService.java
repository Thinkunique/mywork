package com.online.service;

import java.util.List;

import com.online.model.Car;
import com.online.model.User;
import com.online.response.ProductResponse;

public interface ProductService {

	public ProductResponse addNewCar(Car car);
	
	public List<Car> retrieveCars(User seller);
	
}
