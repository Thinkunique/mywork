package com.online.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.online.model.Car;
import com.online.model.CarPhoto;
import com.online.response.ProductResponse;

public interface ProductService {

	public ProductResponse addNewCar(Car car);
	
	public List<Car> retrieveCarsForAdmin();
	
	public List<Car> retrieveCarsForBuyer();
	
	public Car retrieveCarByCarId(String carId);
	
	public void setCarSellingPrice(String carId,String sellingPrice);
	
	public void updateAuctionState(String carId,String auctionState);
	
	public ProductResponse approveSalesPrice(Car car,boolean salesPriceApproved);
	
	public ProductResponse restartAuctionForCar(Car car);
	
	public String addPhoto(String carId,String title, MultipartFile file);
	
	public CarPhoto getPhoto(String id);
	
}
