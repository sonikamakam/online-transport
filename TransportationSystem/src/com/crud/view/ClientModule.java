package com.crud.view;

public interface ClientModule {
	
	void searchByVehicleType();
	void viewVehicleTypes();
	void bookVehicle(String userId, String userName);
	void viewBookings(String userId);
	void returnVehicle(String userId);
}
