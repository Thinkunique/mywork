package com.bidding.validate.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.bidding.model.AuctionDetails;
import com.bidding.model.BiddingDetails;
import com.bidding.repository.AuctionRepository;
import com.bidding.repository.RedisRepository;
import com.bidding.validate.service.ValidateBidService;

@Service
public class ValidateBidServiceImpl implements ValidateBidService {

	@Autowired
	RedisRepository redisRepository;

	@Override
	public boolean isBidValid(BiddingDetails bid) {
		String price = redisRepository.getMaxPrice(bid.getCarId());
		if (price == null || Integer.parseInt(bid.getBidAmount()) > Integer.parseInt(price)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean validateAuctionState(AuctionDetails auctionDetails) {
		if (auctionDetails.getState().equals("started")) {
			return true;
		}
		return false;
	}

}
