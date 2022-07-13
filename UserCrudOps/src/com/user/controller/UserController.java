package com.user.controller;

import java.util.List;

import com.user.model.User;
import com.user.service.UserService;

public class UserController {
	UserService userservice;

	public UserController() {
		userservice = new UserService();
	}

	public int insertRecord(User user) {
		int res = userservice.insertRecord(user);
		return res;
	}

	public int updateRecord(User user) {
		int result = userservice.updateRecord(user);
		return result;
	}

	public int deleteRecord(int id) {
		int result = userservice.deleteRecord(id);
		return result;
	}

	public List<User> getAllRecords() {
		List<User> list = userservice.getAllRecords();
		return list;
	}

	public User getUserbyId(int id) {
		User usr = userservice.getUserbyId(id);
		return usr;

	}

}
