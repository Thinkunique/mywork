package com.online.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.online.model.User;
import com.online.repository.UserRepository;
import com.online.users.TestConfig;
import com.online.util.UserUtility;



@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=TestConfig.class)
public class UserServiceTest {

	@Autowired
	UserRepository repository;
	
	@Autowired
	UserService userService;
	
	@Test
	public void retrieveBuyersTest()
	{
		List<User> buyers=UserUtility.buildBuyers();
		Mockito.when(repository.findByRole("buyer")).thenReturn(buyers);
		List<User> response=userService.getAllBuyers();
		assertEquals(response.size(),buyers.size());
	}
	
	@Test
	public void retrieveSellersTest()
	{
		List<User> sellers=UserUtility.buildSellers();
		Mockito.when(repository.findByRole("seller")).thenReturn(sellers);
		List<User> response=userService.getAllSellers();
		assertEquals(response.size(),sellers.size());
	}
	
	@Test
	public void retrieveAdminsTest()
	{
		List<User> admins=UserUtility.buildAdmins();
		Mockito.when(repository.findByRole("admin")).thenReturn(admins);
		List<User> response=userService.getAllAdmins();
		assertEquals(response.size(),admins.size());	
	}
}
