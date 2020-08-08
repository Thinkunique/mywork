package com.online.controller;

import java.util.List;

import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.online.model.User;
import com.online.response.UserResponse;
import com.online.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/users")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Create new user", response = UserResponse.class)
	public ResponseEntity<UserResponse> createUser(@RequestBody User user) {
		UserResponse response = userService.addUser(user);
		return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
	}

	@GetMapping("/buyers")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "fetch all buyers", response = List.class)
	public ResponseEntity<List<User>> getAllBuyers() {
		List<User> response = userService.getAllBuyers();
		return new ResponseEntity<List<User>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/sellers")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "fetch all sellers", response = List.class)
	public ResponseEntity<List<User>> getAllSellers() {
		List<User> response = userService.getAllSellers();
		return new ResponseEntity<List<User>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/admins")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "fetch all admins", response = List.class)
	public ResponseEntity<List<User>> getAllAdmins() {
		List<User> response = userService.getAllAdmins();
		return new ResponseEntity<List<User>>(response, HttpStatus.OK);
	}
	
}
