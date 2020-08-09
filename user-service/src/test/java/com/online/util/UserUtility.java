package com.online.util;

import java.util.LinkedList;
import java.util.List;

import com.online.model.User;

public class UserUtility {

	public static List<User> buildBuyers() {
		List<User> buyers = new LinkedList<>();
		for (int i = 1; i <= 10; i++) {
			buyers.add(buildUser(String.valueOf(i), "buyer"));
		}
		return buyers;
	}

	public static List<User> buildSellers() {
		List<User> sellers = new LinkedList<>();
		for (int i = 1; i <= 5; i++) {
			sellers.add(buildUser(String.valueOf(i), "seller"));
		}
		return sellers;
	}

	public static List<User> buildAdmins() {
		List<User> admins = new LinkedList<>();
		for (int i = 1; i <= 3; i++) {
			admins.add(buildUser(String.valueOf(i), "admin"));
		}
		return admins;
	}

	public static User buildUser(String id, String role) {
		User user = new User();
		user.setFirstName("dfdfsd");
		user.setLastName("dfsdfsdf");
		user.setEmail("fafasf@sfsf.in");
		user.setUserId(id);
		user.setRole(role);
		return user;
	}

}
