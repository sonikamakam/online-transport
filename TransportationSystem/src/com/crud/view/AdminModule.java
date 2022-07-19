package com.crud.view;

public interface AdminModule {
	
	public boolean removeManager() throws Exception;
	public boolean editManagerDetails() throws Exception;
	public boolean newManager() throws Exception;
	public void getManagerDetails();
	public void getUserDetails();
	void viewBookings();
}
