package com.online.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.online.model.AuctionEvent;
import com.online.service.AuctionEventService;
import com.online.service.ProductService;

@Service
public class AuctionEventServiceImpl implements AuctionEventService {

	@Autowired
	ProductService productService;
	
	@Autowired
	KafkaTemplate<String,AuctionEvent> kafkaTemplate;
	
	@Value("${kafka.auction.restart.topic}")
	private String autionRestartEventTopic;
	
	@Override
	@KafkaListener(topics = "auction-stop-event",groupId = "auction-group1",containerFactory = "kafkaListener")
	public void auctionStartEvent(AuctionEvent event) {
		productService.setCarSellingPrice(event.getCarId(), event.getMaxPrice());
	}
	
	@Override
	@KafkaListener(topics = "auction-start-event",groupId = "auction-group2",containerFactory = "kafkaListener")
	public void auctionStopEvent(AuctionEvent event) {
		productService.updateAuctionState(event.getCarId(), "start");
	}

	@Override
	@KafkaListener(topics = "auction-suspend-event",groupId = "auction-group3",containerFactory = "kafkaListener")
	public void auctionSuspendEvent(AuctionEvent event) {
		productService.updateAuctionState(event.getCarId(), "suspend");
	}

	@Override
	public void auctionRestartEvent(AuctionEvent event) {
		kafkaTemplate.send(autionRestartEventTopic, event);
	}

}
