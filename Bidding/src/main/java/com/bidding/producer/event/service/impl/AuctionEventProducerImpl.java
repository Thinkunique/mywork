package com.bidding.producer.event.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.bidding.producer.event.service.AuctionEventProducer;
import com.online.model.AuctionEvent;

@Service
public class AuctionEventProducerImpl implements AuctionEventProducer {

	@Autowired
	KafkaTemplate<String,AuctionEvent> kafkaTemplate;
	
	@Value("${kafka.auction.start.topic}")
	private String autionStartEventTopic;
	
	@Value("${kafka.auction.stop.topic}")
	private String autionStopEventTopic;

	@Value("${kafka.auction.suspend.topic}")
	private String autionSuspendEventTopic;
	
	@Override
	public void auctionStartEvent(AuctionEvent event) {
		kafkaTemplate.send(autionStartEventTopic, event);
	}
	
	@Override
	public void auctionStopEvent(AuctionEvent event) {
		kafkaTemplate.send(autionStopEventTopic, event);
	}

	@Override
	public void auctionSuspendEvent(AuctionEvent event) {
		kafkaTemplate.send(autionSuspendEventTopic, event);
	}
	
}
