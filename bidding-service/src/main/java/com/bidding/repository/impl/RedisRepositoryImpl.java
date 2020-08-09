package com.bidding.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.bidding.repository.RedisRepository;

@Service
public class RedisRepositoryImpl implements RedisRepository {

	@Autowired
	RedisTemplate<String, String> redisTemplate;

	@Override
	public void updateMaxPrice(String carId, String price) {
		redisTemplate.opsForHash().put("Cars", carId, price);
	}

	@Override
	public String getMaxPrice(String carId) {
		String price = (String) redisTemplate.opsForHash().get("Cars", carId);
		return price;
	}

	@Override
	public void deleteCarId(String carId) {
		redisTemplate.delete(carId);
	}

}
