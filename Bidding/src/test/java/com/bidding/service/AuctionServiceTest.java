package com.bidding.service;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bidding.model.AuctionDetails;
import com.bidding.producer.event.service.AuctionEventProducer;
import com.bidding.repository.AuctionRepository;
import com.bidding.repository.RedisRepository;
import com.bidding.system.TestConfig;
import com.bidding.util.AuctionEventBuilder;
import com.bidding.util.AuctionUtility;
import com.online.model.AuctionEvent;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=TestConfig.class)
public class AuctionServiceTest {

	@Autowired
	AuctionRepository repository;

	@Autowired
	RedisRepository redisRepository;
	
	@Autowired
	AuctionEventProducer eventService;
	
	@Autowired
	KafkaTemplate<String,AuctionEvent> kafkaTemplate;
	
	@Autowired
	AuctionService auctionService;
	
	@Test
	public void startAuction()
	{
		AuctionDetails details=AuctionUtility.buildAuctionDetails();
		details.setState("start");
		String autionStartEventTopic="auction-start-event";
		AuctionEvent event=AuctionEventBuilder.buildAuctionEvent(details.getCarId());
		Mockito.when(repository.save(details)).thenReturn(details);
		Mockito.when(kafkaTemplate.send(autionStartEventTopic, event)).thenReturn(null);
		auctionService.startAuction(details);
	}
	
	@Test
	public void stopAuction()
	{
		AuctionDetails details=AuctionUtility.buildAuctionDetails();
		details.setState("stop");
		String autionStartEventTopic="auction-stop-event";
		AuctionEvent event=AuctionEventBuilder.buildAuctionEvent(details.getCarId());
		Mockito.when(repository.save(details)).thenReturn(details);
		Mockito.when(kafkaTemplate.send(autionStartEventTopic, event)).thenReturn(null);
		auctionService.startAuction(details);
	}
	
	@Test
	public void suspendAuction()
	{
		AuctionDetails details=AuctionUtility.buildAuctionDetails();
		details.setState("suspend");
		String autionStartEventTopic="auction-suspend-event";
		AuctionEvent event=AuctionEventBuilder.buildAuctionEvent(details.getCarId());
		Mockito.when(repository.save(details)).thenReturn(details);
		Mockito.when(kafkaTemplate.send(autionStartEventTopic, event)).thenReturn(null);
		auctionService.startAuction(details);
	}
}
