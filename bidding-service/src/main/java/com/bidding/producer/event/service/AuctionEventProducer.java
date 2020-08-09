package com.bidding.producer.event.service;

import com.online.model.AuctionEvent;

public interface AuctionEventProducer {

	public void auctionStartEvent(AuctionEvent event);
	
	public void auctionStopEvent(AuctionEvent event);
	
	public void auctionSuspendEvent(AuctionEvent event);
	
}
