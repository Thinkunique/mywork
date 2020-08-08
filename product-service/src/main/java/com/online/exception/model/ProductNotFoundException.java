package com.online.exception.model;

public class ProductNotFoundException extends RuntimeException {

	public ProductNotFoundException(String msg)
	{
		super(msg);
	}
	
}
