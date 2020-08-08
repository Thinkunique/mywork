package com.online.service;

import java.util.List;

import com.online.model.User;
import com.online.response.UserResponse;

public interface UserService {
	
	public List<User> getAllBuyers();
	
	public List<User> getAllSellers();
	
	public List<User> getAllAdmins();
	
	public UserResponse addUser(User user);
}
