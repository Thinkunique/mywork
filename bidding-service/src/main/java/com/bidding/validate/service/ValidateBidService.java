package com.bidding.validate.service;

import com.bidding.model.AuctionDetails;
import com.bidding.model.BiddingDetails;

public interface ValidateBidService {

	public boolean isBidValid(BiddingDetails bid);
	
	public boolean validateAuctionState(AuctionDetails auctionDetails);
	
}
