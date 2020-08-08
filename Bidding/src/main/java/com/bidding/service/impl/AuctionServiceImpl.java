package com.bidding.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.bidding.model.AuctionDetails;
import com.bidding.repository.AuctionRepository;
import com.bidding.repository.RedisRepository;
import com.bidding.service.AuctionService;
import com.bidding.util.ReponseBuilder;
import com.online.response.AuctionResponse;

@Service
public class AuctionServiceImpl implements AuctionService {

	@Autowired
	AuctionRepository repository;

	@Autowired
	RedisRepository redisRepository;

	@Override
	public AuctionResponse auction(AuctionDetails auctionDetails) {
		if (auctionDetails.getState().equalsIgnoreCase("started")) {
			startAuction(auctionDetails);
			return ReponseBuilder.buildAuctionStartedResponse();
		} else if (auctionDetails.getState().equalsIgnoreCase("stop")) {
			stopAuction(auctionDetails);
			return ReponseBuilder.buildAuctionEndResponse();
		} else if (auctionDetails.getState().equalsIgnoreCase("suspend")) {
			suspendAuction(auctionDetails);
			return ReponseBuilder.buildAuctionSuspendedResponse();
		} else {
			return ReponseBuilder.buildInvalidAuctionStateResponse();
		}
	}

	@Override
	public void startAuction(AuctionDetails auctionDetails) {
		repository.save(auctionDetails);
	}

	@Override
	public void stopAuction(AuctionDetails auctionDetails) {
		repository.save(auctionDetails);
		String price = redisRepository.getMaxPrice(auctionDetails.getCarId());
		System.out.println(price);
	}

	@Override
	public void suspendAuction(AuctionDetails auctionDetails) {
		repository.save(auctionDetails);
	}

	@Override
	public AuctionDetails findAuctionDetails(String carId) {
		AuctionDetails auctionDetails = new AuctionDetails();
		auctionDetails.setCarId(carId);
		Example<AuctionDetails> example = Example.of(auctionDetails);
		Iterable<AuctionDetails> list = repository.findAll(example);
		if (list == null) {
			return null;
		}
		List<AuctionDetails> auctionList = new LinkedList<>();
		for (AuctionDetails details : list) {
			auctionList.add(details);
		}
		if (auctionList.isEmpty()) {
			return null;
		}
		AuctionDetails details = auctionList.get(0);
		return details;
	}

}
