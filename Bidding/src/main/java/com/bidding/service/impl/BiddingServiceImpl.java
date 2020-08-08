package com.bidding.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.bidding.model.AuctionDetails;
import com.bidding.model.BiddingDetails;
import com.bidding.repository.BiddingRepository;
import com.bidding.repository.RedisRepository;
import com.bidding.service.AuctionService;
import com.bidding.service.BiddingService;
import com.bidding.validate.service.ValidateBidService;
import com.online.response.BidResponse;

@Service
public class BiddingServiceImpl implements BiddingService {

	@Autowired
	BiddingRepository repository;

	@Autowired
	RedisRepository redisRepository;

	@Autowired
	ValidateBidService validateBidService;

	@Autowired
	AuctionService auctionService;

	@Override
	public BidResponse placeBid(BiddingDetails bid) {
		AuctionDetails auctionDetails = auctionService.findAuctionDetails(bid.getCarId());
		if (auctionDetails == null) {
			return com.bidding.util.ReponseBuilder.buildAuctionNotStartedResponse();
		} else if (!validateBidService.validateAuctionState(auctionDetails)) {
			return com.bidding.util.ReponseBuilder.buildAuctionStoppedResponse();
		} else if (!validateBidService.isBidValid(bid)) {
			return com.bidding.util.ReponseBuilder.buildInvalidBidResponse();
		} else {
			repository.save(bid);
			redisRepository.updateMaxPrice(bid.getCarId(), bid.getBidAmount());
			return com.bidding.util.ReponseBuilder.buildBidSuccessResponse();
		}
	}

	@Override
	public List<BiddingDetails> getBiddingDetailsForAdmin(String carId) {
		BiddingDetails biddingDetails = new BiddingDetails();
		biddingDetails.setCarId(carId);
		Example<BiddingDetails> example = Example.of(biddingDetails);
		Iterable<BiddingDetails> list = repository.findAll(example);
		List<BiddingDetails> responseList = new LinkedList<>();
		for (BiddingDetails details : list) {
			responseList.add(details);
		}
		return responseList;
	}

	@Override
	public List<BiddingDetails> getBiddingDetailsForBuyer(String buyerId, String carId) {
		BiddingDetails biddingDetails = new BiddingDetails();
		biddingDetails.setCarId(carId);
		biddingDetails.setBuyerId(buyerId);
		Example<BiddingDetails> example = Example.of(biddingDetails);
		Iterable<BiddingDetails> list = repository.findAll(example);
		List<BiddingDetails> responseList = new LinkedList<>();
		for (BiddingDetails details : list) {
			responseList.add(details);
		}
		return responseList;
	}

}
