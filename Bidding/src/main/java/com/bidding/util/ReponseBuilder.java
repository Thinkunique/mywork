package com.bidding.util;

import com.online.response.AuctionResponse;
import com.online.response.BidResponse;

public class ReponseBuilder {

	public static AuctionResponse buildAuctionStartedResponse() {
		AuctionResponse response = new AuctionResponse();
		response.setCode("200");
		response.setMessage("Auction has started successfully");
		return response;
	}

	public static AuctionResponse buildAuctionEndResponse() {
		AuctionResponse response = new AuctionResponse();
		response.setCode("200");
		response.setMessage("Auction has stopped successfully");
		return response;
	}
	
	public static AuctionResponse buildAuctionSuspendedResponse() {
		AuctionResponse response = new AuctionResponse();
		response.setCode("200");
		response.setMessage("Auction has suspended successfully");
		return response;
	}
	
	public static AuctionResponse buildInvalidAuctionStateResponse() {
		AuctionResponse response = new AuctionResponse();
		response.setCode("400");
		response.setMessage("Auction state is invalid");
		return response;
	}
	
	public static BidResponse buildBidSuccessResponse() {
		BidResponse response = new BidResponse();
		response.setCode("200");
		response.setMessage("Bid placed successfully");
		return response;
	}
	
	public static BidResponse buildInvalidBidResponse() {
		BidResponse response = new BidResponse();
		response.setCode("400");
		response.setMessage("Invalid bid amout: should be greater than max bid amout.");
		return response;
	}
	
	public static BidResponse buildAuctionNotStartedResponse() {
		BidResponse response = new BidResponse();
		response.setCode("400");
		response.setMessage("Auction not started for car.");
		return response;
	}
	
	public static BidResponse buildAuctionStoppedResponse() {
		BidResponse response = new BidResponse();
		response.setCode("400");
		response.setMessage("Auction has been stopped or suspended for car.");
		return response;
	}

}
