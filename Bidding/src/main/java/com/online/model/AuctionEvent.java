package com.online.model;

public class AuctionEvent {

	private String CarId;
	
	private String maxPrice;
	
	public AuctionEvent()
	{
		
	}
	
	/**
	 * @param carId
	 * @param maxPrice
	 */
	public AuctionEvent(String carId, String maxPrice) {
		super();
		CarId = carId;
		this.maxPrice = maxPrice;
	}

	/**
	 * @return the carId
	 */
	public String getCarId() {
		return CarId;
	}

	/**
	 * @param carId the carId to set
	 */
	public void setCarId(String carId) {
		CarId = carId;
	}

	/**
	 * @return the maxPrice
	 */
	public String getMaxPrice() {
		return maxPrice;
	}

	/**
	 * @param maxPrice the maxPrice to set
	 */
	public void setMaxPrice(String maxPrice) {
		this.maxPrice = maxPrice;
	}
	
	
	
}
