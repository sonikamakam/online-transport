package com.crud.view;


public interface ManagerModule {
	
	public boolean addVehicle();
	public boolean editVehicle(String id,String role);
	public boolean removeVehicle(String id,String role);
	public void vehicleStatus(String id,String role);
	public void vehicleDetails(String id,String role);
	public boolean editDriverDetails(String id,String role);
	public void driverDetails(String id,String role);
	void viewBookings(String managerId,String role);
	
}
