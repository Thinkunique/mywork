package com.bidding.util;

import com.bidding.model.AuctionDetails;

public class AuctionUtility {

	public static AuctionDetails buildAuctionDetails()
	{
		AuctionDetails details=new AuctionDetails();
		details.setAdminId("1");
		details.setAuctionId("1");
		details.setCarId("1");
		return details;
	}
	
}
