package com.online.service;


import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.online.model.Car;
import com.online.products.TestConfig;
import com.online.repository.CarRepository;
import com.online.response.ProductResponse;
import com.online.util.CarUtility;
import com.online.util.ProductResponseBuilder;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=TestConfig.class)
public class ProductServiceTest {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CarRepository repository;
	
	@Test
	public void addNewCarWithoutSalesPriceTest()
	{
		Car car=CarUtility.buildCar();
		ProductResponse productResponse=ProductResponseBuilder.buildProductResponse();
		Mockito.when(repository.save(car)).thenReturn(car);
		productService.addNewCar(car);
		ProductResponse proResponse=productService.addNewCar(car);
		assertEquals(proResponse.getCode(),productResponse.getCode());
	}
	
	@Test
	public void addNewCarWithSalesPriceTest()
	{
		Car car=CarUtility.buildCar();
		car.setSalesPrice("100");
		ProductResponse productResponse=ProductResponseBuilder.buildProductErrorResponse();
		Mockito.when(repository.save(car)).thenReturn(car);
		productService.addNewCar(car);
		ProductResponse proResponse=productService.addNewCar(car);
		assertEquals(proResponse.getCode(),productResponse.getCode());
	}

}
