package com.bidding.service;

import java.util.List;

import com.bidding.model.BiddingDetails;
import com.online.response.BidResponse;

public interface BiddingService {

	public BidResponse placeBid(BiddingDetails bid);
	
	public List<BiddingDetails> getBiddingDetailsForAdmin(String carId);
	
	public List<BiddingDetails> getBiddingDetailsForBuyer(String buyerId,String carId);
	
}
