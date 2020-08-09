package com.online.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Document(collection = "cars")
public class Car implements Serializable{
	
	@Id
	private String carId;
	
	private String make;
	
	private String model;
	
	private String year;
	
	private String kmsDriven;
	
	private String salesPrice;
	
	private String sellerUserId;
	
	private String auctionState;
	
	@JsonIgnore
	private boolean salesPriceAccepted;
	
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
	 * @return the make
	 */
	public String getMake() {
		return make;
	}

	/**
	 * @param make the make to set
	 */
	public void setMake(String make) {
		this.make = make;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * @return the kmsDriven
	 */
	public String getKmsDriven() {
		return kmsDriven;
	}

	/**
	 * @param kmsDriven the kmsDriven to set
	 */
	public void setKmsDriven(String kmsDriven) {
		this.kmsDriven = kmsDriven;
	}

	/**
	 * @return the salesPrice
	 */
	public String getSalesPrice() {
		return salesPrice;
	}

	/**
	 * @param salesPrice the salesPrice to set
	 */
	public void setSalesPrice(String salesPrice) {
		this.salesPrice = salesPrice;
	}


	/**
	 * @return the auctionState
	 */
	public String getAuctionState() {
		return auctionState;
	}

	/**
	 * @param auctionState the auctionState to set
	 */
	public void setAuctionState(String auctionState) {
		this.auctionState = auctionState;
	}

	/**
	 * @return the sellerUserId
	 */
	public String getSellerUserId() {
		return sellerUserId;
	}

	/**
	 * @param sellerUserId the sellerUserId to set
	 */
	public void setSellerUserId(String sellerUserId) {
		this.sellerUserId = sellerUserId;
	}

	/**
	 * @return the salesPriceAccepted
	 */
	public boolean isSalesPriceAccepted() {
		return salesPriceAccepted;
	}

	/**
	 * @param salesPriceAccepted the salesPriceAccepted to set
	 */
	public void setSalesPriceAccepted(boolean salesPriceAccepted) {
		this.salesPriceAccepted = salesPriceAccepted;
	}
	
	
	
}
