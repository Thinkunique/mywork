package com.online.controller;

import java.util.List;

import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.online.model.Car;
import com.online.model.User;
import com.online.response.ProductResponse;
import com.online.service.ProductService;

import io.swagger.annotations.ApiOperation;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;

	@PostMapping("/seller/cars")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "List car by seller", response = ProductResponse.class)
	public ResponseEntity<ProductResponse> addNewProduct(@RequestBody Car car) {
		ProductResponse response = productService.addNewCar(car);
		return new ResponseEntity<ProductResponse>(response, HttpStatus.OK);
	}

	@PostMapping("/admin/cars")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Retrieve car by Seller", response = List.class)
	public ResponseEntity<List<Car>> retrieveProductDetails(@RequestBody User seller) {
		List<Car> response = productService.retrieveCars(seller);
		return new ResponseEntity<List<Car>>(response, HttpStatus.OK);
	}

}
