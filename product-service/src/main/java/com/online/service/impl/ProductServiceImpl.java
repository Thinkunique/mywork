package com.online.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.online.model.AuctionEvent;
import com.online.model.Car;
import com.online.model.CarPhoto;
import com.online.repository.CarRepository;
import com.online.response.ProductResponse;
import com.online.service.AuctionEventService;
import com.online.service.PhotoService;
import com.online.service.ProductService;
import com.online.util.AuctionEventBuilder;
import com.online.util.ProductResponseBuilder;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	CarRepository repository;
	
	@Autowired
	AuctionEventService eventService;

	@Autowired
	PhotoService photoService;
	
	@Override
	public ProductResponse addNewCar(Car car) {
		if (car.getSalesPrice() != null) {
			return ProductResponseBuilder.buildProductErrorResponse();
		}
		repository.save(car);
		return ProductResponseBuilder.buildProductResponse();
	}

	@Override
	public void setCarSellingPrice(String carId, String sellingPrice) {
		Car car = repository.findByCarId(carId);
		car.setSalesPrice(sellingPrice);
		car.setAuctionState("stop");
		repository.save(car);
	}

	@Override
	public void updateAuctionState(String carId, String auctionState) {
		Car car = repository.findByCarId(carId);
		if (auctionState.equalsIgnoreCase("suspend")) {
			car.setSalesPrice(null);
		}
		car.setAuctionState(auctionState);
		repository.save(car);
	}

	@Override
	public Car retrieveCarByCarId(String carId) {
		return repository.findByCarId(carId);
	}

	@Override
	public List<Car> retrieveCarsForBuyer() {
		List<Car> list = repository.findAll();
		return list.stream().filter(x -> x.getAuctionState() == null || x.getAuctionState().equalsIgnoreCase("start")
				|| x.getAuctionState().equalsIgnoreCase("stop")).collect(Collectors.toList());
	}

	@Override
	public List<Car> retrieveCarsForAdmin() {
		return repository.findAll();
	}

	@Override
	public ProductResponse approveSalesPrice(Car car,boolean salesPriceApproved) {
		car.setSalesPriceAccepted(salesPriceApproved);
		repository.save(car);
		return ProductResponseBuilder.buildProductApprovedResponse();
	}

	@Override
	public ProductResponse restartAuctionForCar(Car car) {
		car.setAuctionState("restart");
		car.setSalesPrice(null);
		car.setSalesPriceAccepted(false);
		repository.save(car);
		AuctionEvent event=AuctionEventBuilder.buildAuctionEvent(car.getCarId());
		eventService.auctionRestartEvent(event);
		return ProductResponseBuilder.buildAuctionRestartResponse();
	}

	@Override
	public String addPhoto(String carId,String title, MultipartFile file) {
		return this.photoService.addPhoto(carId,title, file);
	}

	@Override
	public CarPhoto getPhoto(String id) {
		return this.photoService.getPhoto(id);
	}
}
