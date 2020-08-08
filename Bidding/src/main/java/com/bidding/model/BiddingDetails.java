package com.bidding.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document(collection = "bids")
public class BiddingDetails {

	@Id
	@JsonIgnore
	private String bidId;
	
	private String buyerId;
	
	private String carId;
	
	private String bidAmount;
	
	private Date createdDate;

	/**
	 * @return the bidId
	 */
	public String getBidId() {
		return bidId;
	}

	/**
	 * @param bidId the bidId to set
	 */
	public void setBidId(String bidId) {
		this.bidId = bidId;
	}

	
	/**
	 * @return the buyerId
	 */
	public String getBuyerId() {
		return buyerId;
	}

	/**
	 * @param buyerId the buyerId to set
	 */
	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	/**
	 * @return the carId
	 */
	public String getCarId() {
		return carId;
	}

	/**
	 * @param carId the carId to set
	 */
	public void setCarId(String carId) {
		this.carId = carId;
	}

	/**
	 * @return the bidAmount
	 */
	public String getBidAmount() {
		return bidAmount;
	}

	/**
	 * @param bidAmount the bidAmount to set
	 */
	public void setBidAmount(String bidAmount) {
		this.bidAmount = bidAmount;
	}

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	
	
}
