package com.bidding.consumer.event.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.bidding.consumer.event.service.AuctionEventConsumer;
import com.bidding.service.AuctionService;
import com.online.model.AuctionEvent;

@Service
public class AuctionEventConsumerImpl implements AuctionEventConsumer {
	
	@Autowired
	AuctionService auctionService;

	@Override
	@KafkaListener(topics = "auction-restart-event",groupId = "auction-restart-group",containerFactory = "kafkaListener")
	public void auctionRestartEvent(AuctionEvent event) {
		auctionService.restartAuction(event);
	}
}
