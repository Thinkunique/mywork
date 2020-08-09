package com.bidding.service;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bidding.model.AuctionDetails;
import com.bidding.model.BiddingDetails;
import com.bidding.repository.BiddingRepository;
import com.bidding.repository.RedisRepository;
import com.bidding.system.TestConfig;
import com.bidding.util.AuctionUtility;
import com.bidding.validate.service.ValidateBidService;
import com.online.response.BidResponse;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=TestConfig.class)
public class BiddingServiceTest {

	@Autowired
	BiddingRepository repository;

	@Autowired
	RedisRepository redisRepository;

	@Autowired
	ValidateBidService validateBidService;

	@Autowired
	AuctionService auctionService;
	
	@Autowired
	BiddingService biddingService;

	@Test
	public void placeBidForNoAuctionTest()
	{
		AuctionDetails auctionDetails=null;
		BiddingDetails details=new BiddingDetails();
		details.setCarId("1");
		BidResponse testResponse=com.bidding.util.ReponseBuilder.buildAuctionNotStartedResponse();
		Mockito.when(auctionService.findAuctionDetails("1")).thenReturn(auctionDetails);
		BidResponse response=biddingService.placeBid(details);
		assertEquals(response.getCode(),testResponse.getCode());
	}
	
	@Test
	public void placeBidAuctionStoppedTest()
	{
		AuctionDetails auctionDetails=AuctionUtility.buildAuctionDetails();
		auctionDetails.setState("stop");
		BiddingDetails details=new BiddingDetails();
		details.setCarId("1");
		BidResponse testResponse=com.bidding.util.ReponseBuilder.buildAuctionStoppedResponse();
		Mockito.when(auctionService.findAuctionDetails("1")).thenReturn(auctionDetails);
		BidResponse response=biddingService.placeBid(details);
		assertEquals(response.getCode(),testResponse.getCode());
	}
	
	@Test
	public void placeBidAuctionSuspendTest()
	{
		AuctionDetails auctionDetails=AuctionUtility.buildAuctionDetails();
		auctionDetails.setState("suspend");
		BiddingDetails details=new BiddingDetails();
		details.setCarId("1");
		BidResponse testResponse=com.bidding.util.ReponseBuilder.buildAuctionStoppedResponse();
		Mockito.when(auctionService.findAuctionDetails("1")).thenReturn(auctionDetails);
		BidResponse response=biddingService.placeBid(details);
		assertEquals(response.getCode(),testResponse.getCode());
	}
}
