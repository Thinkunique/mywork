package com.bidding.repository;

import com.online.model.Car;

public interface RedisRepository {

	public void updateMaxPrice(String carId, String price);
	
	public String getMaxPrice(String carId);
}
