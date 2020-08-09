package com.bidding.repository;


public interface RedisRepository {

	public void updateMaxPrice(String carId, String price);
	
	public String getMaxPrice(String carId);
	
	public void deleteCarId(String carId);
}
