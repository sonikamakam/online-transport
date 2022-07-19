package com.crud.service;

import java.util.List;

import com.crud.model.Vehicle;

public interface ManagerService {
	
	public boolean addVehicle(Vehicle vehicle);
	public boolean removeVehicle(int vehicleId);
	public List<List<String>> vehicleStatus(String managerType,String role);
	public List<List<String>> vehicleDetails(String managerBrranch,String role);
	boolean editVehicleDetails(int vehicleID, String field, String newData);
	boolean editDriverDetails(int vehicleId, String newDriver, String phoneNumber);
	List<List<String>> driverDetails(String managerType,String role);
	List<List<String>> viewBookings(String managerType,String role);
	String getManagerBranch(String managerId);

}
