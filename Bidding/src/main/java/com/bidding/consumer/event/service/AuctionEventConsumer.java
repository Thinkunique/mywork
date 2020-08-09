package com.bidding.consumer.event.service;

import com.online.model.AuctionEvent;

public interface AuctionEventConsumer {

	public void auctionRestartEvent(AuctionEvent event);
}
