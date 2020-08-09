package com.bidding.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.bidding.model.AuctionDetails;
import com.bidding.producer.event.service.AuctionEventProducer;
import com.bidding.repository.AuctionRepository;
import com.bidding.repository.RedisRepository;
import com.bidding.service.AuctionService;
import com.bidding.util.AuctionEventBuilder;
import com.bidding.util.ReponseBuilder;
import com.online.model.AuctionEvent;
import com.online.response.AuctionResponse;

@Service
public class AuctionServiceImpl implements AuctionService {

	@Autowired
	AuctionRepository repository;

	@Autowired
	RedisRepository redisRepository;
	
	@Autowired
	AuctionEventProducer eventService;

	@Override
	public AuctionResponse auction(AuctionDetails auctionDetails) {
		if (auctionDetails.getState().equalsIgnoreCase("start")) {
			startAuction(auctionDetails);
			return ReponseBuilder.buildAuctionStartedResponse();
		} else if (auctionDetails.getState().equalsIgnoreCase("stop")) {
			stopAuction(auctionDetails);
			return ReponseBuilder.buildAuctionEndResponse();
		} else if (auctionDetails.getState().equalsIgnoreCase("suspend")) {
			suspendAuction(auctionDetails);
			return ReponseBuilder.buildAuctionSuspendedResponse();
		} else {
			return ReponseBuilder.buildInvalidAuctionStateResponse();
		}
	}

	@Override
	public void startAuction(AuctionDetails auctionDetails) {
		repository.save(auctionDetails);
		AuctionEvent event=AuctionEventBuilder.buildAuctionEvent(auctionDetails.getCarId());
		eventService.auctionStartEvent(event);
	}

	@Override
	public void stopAuction(AuctionDetails auctionDetails) {
		repository.save(auctionDetails);
		String sellingPrice = redisRepository.getMaxPrice(auctionDetails.getCarId());
		AuctionEvent event=AuctionEventBuilder.buildAuctionStopEvent(auctionDetails.getCarId(), sellingPrice);
		eventService.auctionStopEvent(event);
	}

	@Override
	public void suspendAuction(AuctionDetails auctionDetails) {
		repository.save(auctionDetails);
		AuctionEvent event=AuctionEventBuilder.buildAuctionEvent(auctionDetails.getCarId());
		eventService.auctionSuspendEvent(event);
	}

	@Override
	public AuctionDetails findAuctionDetails(String carId) {
		AuctionDetails auctionDetails = new AuctionDetails();
		auctionDetails.setCarId(carId);
		Example<AuctionDetails> example = Example.of(auctionDetails);
		Iterable<AuctionDetails> list = repository.findAll(example);
		if (list == null) {
			return null;
		}
		List<AuctionDetails> auctionList = new LinkedList<>();
		for (AuctionDetails details : list) {
			auctionList.add(details);
		}
		if (auctionList.isEmpty()) {
			return null;
		}
		AuctionDetails details = auctionList.get(0);
		return details;
	}

	@Override
	public void restartAuction(AuctionEvent event) {
		AuctionDetails auctionDetails= findAuctionDetails(event.getCarId());
		auctionDetails.setState("restart");
		redisRepository.updateMaxPrice(event.getCarId(),"0");
		repository.save(auctionDetails);
	}

}
