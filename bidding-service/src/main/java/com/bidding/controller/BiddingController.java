package com.bidding.controller;

import java.util.List;

import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bidding.model.AuctionDetails;
import com.bidding.model.BiddingDetails;
import com.bidding.service.AuctionService;
import com.bidding.service.BiddingService;
import com.online.response.AuctionResponse;
import com.online.response.BidResponse;

import io.swagger.annotations.ApiOperation;

@RestController
public class BiddingController {

	@Autowired
	BiddingService biddingService;
	
	@Autowired
	AuctionService auctionService;

	@PostMapping("/buyer/car/bid")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Buyer can place bid for Car", response = BidResponse.class)
	public ResponseEntity<BidResponse> placeBid(@RequestBody BiddingDetails bid) {
		BidResponse response = biddingService.placeBid(bid);
		return new ResponseEntity<BidResponse>(response, HttpStatus.OK);
	}
	
	@GetMapping("/buyer/car/bids")
	@ApiOperation(value = "Buyer can retrieve his bid history for Car", response = BidResponse.class)
	public ResponseEntity<List<BiddingDetails>> retrieveBids(@RequestParam("buyerId") String buyerId,@RequestParam("carId") String carId) {
		List<BiddingDetails> response = biddingService.getBiddingDetailsForBuyer(buyerId,carId);
		return new ResponseEntity<List<BiddingDetails>>(response, HttpStatus.OK);
	}

	@GetMapping("/admin/car/bids")
	@ApiOperation(value = "Admin can retrieve entire bid history of Car", response = List.class)
	public ResponseEntity<List<BiddingDetails>> getAllBids(@RequestParam("carId") String carId) {
		List<BiddingDetails> response = biddingService.getBiddingDetailsForAdmin(carId);
		return new ResponseEntity<List<BiddingDetails>>(response, HttpStatus.OK);
	}

	@PostMapping("/admin/auction")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Start, stop or suspend auction for Car", response = List.class)
	public ResponseEntity<AuctionResponse> auctionForCar(@RequestBody AuctionDetails auctionDetails) {
		AuctionResponse response = auctionService.auction(auctionDetails);
		return new ResponseEntity<AuctionResponse>(response, HttpStatus.OK);
	}
	
}
