package com.online.util;

import com.online.model.AuctionEvent;

public class AuctionEventBuilder {
	
	public static AuctionEvent buildAuctionEvent(String carId)
	{
		AuctionEvent event=new AuctionEvent();
		event.setCarId(carId);
		return event;
	}
	
}
