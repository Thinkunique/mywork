package com.online.util;

import com.online.response.ProductResponse;

public class ProductResponseBuilder {

	public static ProductResponse buildProductResponse()
	{
		ProductResponse response = new ProductResponse();
		response.setCode("200");
		response.setMessage("car added successfully");
		return response;
	}
	
	public static ProductResponse buildProductApprovedResponse()
	{
		ProductResponse response = new ProductResponse();
		response.setCode("200");
		response.setMessage("Sales price is approved successfully.");
		return response;
	}
	
	public static ProductResponse buildProductErrorResponse()
	{
		ProductResponse response = new ProductResponse();
		response.setCode("400");
		response.setMessage("Seller price should be null");
		return response;
	}
	
	public static ProductResponse buildAuctionRestartResponse()
	{
		ProductResponse response = new ProductResponse();
		response.setCode("200");
		response.setMessage("Auction restarted successfully.");
		return response;
	}
	
}
