package com.crud.service;

import java.util.List;

import com.crud.model.Manager;
import com.crud.model.User;

public interface AdminService {
	
	public boolean removeManager(int managerId) throws Exception;
	public boolean editManagerDetails(int managerId, String field, String newData) throws Exception;
	public boolean addManager(Manager managerDetails,User user) throws Exception;
	public List<List<String>> getManagerDetails();
	public List<List<String>> getUserDetails();
	List<List<String>> viewBookings();
}
