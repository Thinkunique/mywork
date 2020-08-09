package com.online.service;

import com.online.model.AuctionEvent;

public interface AuctionEventService {

	public void auctionStopEvent(AuctionEvent event);
	
	public void auctionSuspendEvent(AuctionEvent event);
	
	public void auctionStartEvent(AuctionEvent event);
	
	public void auctionRestartEvent(AuctionEvent event);
	
}
