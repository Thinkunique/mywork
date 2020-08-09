package com.bidding.util;

import com.online.model.AuctionEvent;

public class AuctionEventBuilder {

	public static AuctionEvent buildAuctionStopEvent(String carId,String sellingPrice)
	{
		AuctionEvent event=new AuctionEvent();
		event.setCarId(carId);
		event.setMaxPrice(sellingPrice);
		return event;
	}
	
	public static AuctionEvent buildAuctionEvent(String carId)
	{
		AuctionEvent event=new AuctionEvent();
		event.setCarId(carId);
		return event;
	}
	
}
