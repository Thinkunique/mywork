package com.online.exception.model;

public class UserNotFoundException extends RuntimeException  {

	public UserNotFoundException(String msg)
	{
		super(msg);
	}
	
}
