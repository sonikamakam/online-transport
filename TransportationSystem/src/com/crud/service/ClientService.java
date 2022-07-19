package com.crud.service;

import java.util.List;

public interface ClientService {

	List<List<String>> viewVehicleTypes();
	List<List<String>> searchByVehicleType(String type);
	boolean bookVehicle(int vehicleId,int userId, String userName);
	boolean returnVehicle(int bookingId);
	List<List<String>> viewBookings(int userID);
}
