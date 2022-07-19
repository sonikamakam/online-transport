package com.crud.view;

import java.util.List;
import java.util.Scanner;

import com.crud.service.ClientService;
import com.crud.service.ClientServiceImpl;

public class ClientModuleImpl implements ClientModule {

	ClientService objClientService = new ClientServiceImpl();
	Scanner sc = new Scanner(System.in);
	Scanner s = new Scanner(System.in);
	
	public ClientModuleImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ClientModuleImpl(String userName) {
		super();
		System.out.println("Welcome User "+userName+",");
		System.out.println("1.View Vehicle Types");
		System.out.println("2.Filter Vehicle by Type");
		System.out.println("3.Book a Vehicle");
		System.out.println("4.View Bookings");
		System.out.println("5.Return a Vehicle");
		System.out.println("6.Exit");
		System.out.println("Enter Choice : ");
	}

	@Override
	public void searchByVehicleType() {
		viewVehicleTypes();
		System.out.println("Enter Vehicle Type : ");
		String type = sc.nextLine();
		List<List<String>> vehicleByType = objClientService.searchByVehicleType(type);
		System.out.println("SNO\tVehicleId\tVehicleNumber\tVehicleType\tFuelType\tInsurance\tPermit\tAvailability");
		int cnt=1;
		for (List<String> list : vehicleByType) {
			System.out.print(cnt+"\t");
			System.out.print(list.get(0) + "\t\t");
			System.out.print(list.get(1) + "\t");
			System.out.print(list.get(2) + "\t\t");
			System.out.print(list.get(3) + "\t\t");
			System.out.print(list.get(4) + "\t\t");
			System.out.print(list.get(5) + "\t");
			System.out.print(list.get(8) + "\t");
			cnt+=1;
			System.out.println();
		}
	}

	@Override
	public void viewVehicleTypes() {
		List<List<String>> vehicleTypes = objClientService.viewVehicleTypes();
		System.out.println("SNO\tVehicle Type");
		int cnt=1;
		for (List<String> list : vehicleTypes) {
			System.out.print(cnt+"\t");
			System.out.print(list.get(0));
			cnt+=1;
			System.out.println();
		}
	}

	@Override
	public void bookVehicle(String userId, String userName) {
		
		System.out.println("1.Book Using VehicleID");
		System.out.println("2.Search VehicleID");
		int choice = s.nextInt();
		int vID=-1;
		if(choice==1)
		{
			System.out.println("Enter Vehicle ID:");
			vID = s.nextInt();
		}
		else if(choice==2)
		{
			searchByVehicleType();
			System.out.println("Enter Vehicle ID");
			vID = s.nextInt();
		}
		int uID = Integer.parseInt(userId);
		if(vID!=-1)
		{
			if(objClientService.bookVehicle(vID, uID, userName))
				System.out.println("Vehicle Booked");
			else
				System.out.println("Error in Booking Vehicle");
		}
		else
			System.out.println("Error in Booking Vehicle");
	}

	@Override
	public void viewBookings(String userId)
	{
		List<List<String>> bookings = objClientService.viewBookings(Integer.parseInt(userId));
		System.out.println("SNO\tbookingId\tvehicleId\tvehicleNumber\tbookingDate");
		int cnt=1;
		for (List<String> list : bookings) {
			System.out.print(cnt+"\t");
			System.out.print(list.get(0)+"\t\t");
			System.out.print(list.get(1)+"\t\t");
			System.out.print(list.get(2)+"\t");
			System.out.print(list.get(3)+"\t");
			cnt+=1;
			System.out.println();
		}
	}
	
	@Override
	public void returnVehicle(String userId)
	{
		viewBookings(userId);
		System.out.println("Enter Booking Id to return Vehicle");
		int bookingId = s.nextInt();
		if(objClientService.returnVehicle(bookingId))
			System.out.println("Vehicle Returned");
		else
			System.out.println("Error in Returning Vehicle");
	}
}
