package com.crud.service;

import com.crud.exception.WrongCredentialsException;
import com.crud.model.User;

public interface UserService {
	
	public boolean userCreation(User user) throws Exception;
	public boolean checkUserName(String userName);
	public boolean checkUserEmail(String userEmail);
	public String[] validateUser(String userName, String password) throws WrongCredentialsException;
	public int userIdFromDB(String userName);
}
