package com.online.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.exception.model.UserCreationException;
import com.online.model.User;
import com.online.repository.UserRepository;
import com.online.response.UserResponse;
import com.online.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repository;

	@Override
	public List<User> getAllBuyers() {
		return repository.findByRole("buyer");
	}

	@Override
	public List<User> getAllSellers() {
		return repository.findByRole("seller");
	}

	@Override
	public List<User> getAllAdmins() {
		return repository.findByRole("admin");
	}

	@Override
	public UserResponse addUser(User user) {
		UserResponse response = new UserResponse();
		try {
			repository.save(user);
		} catch (Exception e) {
			throw new UserCreationException(e.getMessage());
		}
		response.setCode("200");
		response.setMessage("User created");
		return response;
	}

}
