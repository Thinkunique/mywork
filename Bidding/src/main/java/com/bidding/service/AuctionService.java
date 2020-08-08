package com.bidding.service;

import com.bidding.model.AuctionDetails;
import com.online.response.AuctionResponse;

public interface AuctionService {

	public void startAuction(AuctionDetails auctionDetails);
	
	public void stopAuction(AuctionDetails auctionDetails);
	
	public void suspendAuction(AuctionDetails auctionDetails);
	
	public AuctionResponse auction(AuctionDetails auctionDetails);
	
	public AuctionDetails findAuctionDetails(String carId);
	
}
