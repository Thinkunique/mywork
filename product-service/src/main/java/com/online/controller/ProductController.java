package com.online.controller;

import java.util.Base64;
import java.util.List;

import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.online.model.Car;
import com.online.model.CarPhoto;
import com.online.response.PhotoResponse;
import com.online.response.ProductResponse;
import com.online.service.ProductService;
import com.online.util.PhotoResponseBuilder;

import io.swagger.annotations.ApiOperation;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;

	@PostMapping("/seller/car")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Seller can add or update car", response = ProductResponse.class)
	public ResponseEntity<ProductResponse> addNewProduct(@RequestBody Car car) {
		ProductResponse response = productService.addNewCar(car);
		return new ResponseEntity<ProductResponse>(response, HttpStatus.OK);
	}

	@GetMapping("/admin/cars")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Retrieve all cars listed by any Seller", response = List.class)
	public ResponseEntity<List<Car>> retrieveProductDetails() {
		List<Car> response = productService.retrieveCarsForAdmin();
		return new ResponseEntity<List<Car>>(response, HttpStatus.OK);
	}

	@GetMapping("/seller/auction/car")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Seller can retrieve car details such as state of auction,sales price for car", response = Car.class)
	public ResponseEntity<Car> retrieveAuctionState(@RequestParam("carId") String carId) {
		Car response = productService.retrieveCarByCarId(carId);
		return new ResponseEntity<Car>(response, HttpStatus.OK);
	}

	@GetMapping("/buyer/auction/cars")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Buyer can retrieve all cars in auction except suspended state", response = List.class)
	public ResponseEntity<List<Car>> retrieveCarsForBuyer() {
		List<Car> response = productService.retrieveCarsForBuyer();
		return new ResponseEntity<List<Car>>(response, HttpStatus.OK);
	}

	@PostMapping("/seller/approve/car")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Seller can accept or reject sales price for car", response = ProductResponse.class)
	public ResponseEntity<ProductResponse> retrieveAuctionState(@RequestBody Car car,
			@RequestParam("salesPriceApproved") boolean salesPriceApproved) {
		ProductResponse response = productService.approveSalesPrice(car, salesPriceApproved);
		return new ResponseEntity<ProductResponse>(response, HttpStatus.OK);
	}

	@PostMapping("/admin/restart/auction")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Admin can restart auction for car", response = ProductResponse.class)
	public ResponseEntity<ProductResponse> retartAuctionState(@RequestBody Car car) {
		ProductResponse response = productService.restartAuctionForCar(car);
		return new ResponseEntity<ProductResponse>(response, HttpStatus.OK);
	}

	@PostMapping("seller/car/photos")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Seller can add photo for car", response = PhotoResponse.class)
	public ResponseEntity<PhotoResponse> addPhoto(@RequestParam("carId") String carId,
			@RequestParam("title") String title, @RequestParam("image") MultipartFile image) {
		String photoId = productService.addPhoto(carId, title, image);
		PhotoResponse response = PhotoResponseBuilder.buildPhotoResponse(photoId);
		return new ResponseEntity<PhotoResponse>(response, HttpStatus.OK);
	}

	@GetMapping("seller/car/photos")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Seller can retrieve photo of car", response = PhotoResponse.class)
	public ResponseEntity<PhotoResponse> getPhoto(@RequestParam("photoId") String photoId, Model model) {
		CarPhoto photo = productService.getPhoto(photoId);
		model.addAttribute("title", photo.getTitle());
		model.addAttribute("image", Base64.getEncoder().encodeToString(photo.getImage().getData()));
		PhotoResponse response = PhotoResponseBuilder.buildPhotoRetrievedResponse(photoId);
		return new ResponseEntity<PhotoResponse>(response, HttpStatus.OK);
	}
}
