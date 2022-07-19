package com.crud.view;

import com.crud.exception.WrongCredentialsException;
import com.crud.model.User;
import com.crud.service.UserService;
import com.crud.service.UserServiceImpl;

public class UserModuleImpl implements UserModule {
	

	UserService objUserService = new UserServiceImpl();
	
	@Override
	public boolean userCreation(User user) throws Exception {
		return objUserService.userCreation(user);
	}

	@Override
	public boolean checkUserName(String userName) {
		
		return objUserService.checkUserName(userName);
	}
	
	@Override
	public boolean checkUserEmail(String userEmail) {
		return objUserService.checkUserEmail(userEmail);
	}

	@Override
	public String[] validateUser(String userName, String password)  throws WrongCredentialsException {
		return objUserService.validateUser(userName, password);
	}

}
