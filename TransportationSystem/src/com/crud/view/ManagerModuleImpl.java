package com.crud.view;

import java.util.List;
import java.util.Scanner;

import com.crud.model.Vehicle;
import com.crud.service.ManagerService;
import com.crud.service.ManagerServiceImpl;

public class ManagerModuleImpl implements ManagerModule {
	
	Scanner sc = new Scanner(System.in);
	Scanner s = new Scanner(System.in);
	
	ManagerService objManagerService = new ManagerServiceImpl();

	public ManagerModuleImpl() {
		super();
	}

	public ManagerModuleImpl(String userName) {
		super();
		System.out.println("Welcome Manager " + userName+",");
		System.out.println("1.Add Vehicle");
		System.out.println("2.Edit Vehicle Details");
		System.out.println("3.Remove Vehicle");
		System.out.println("4.Vehicle Details");
		System.out.println("5.Get Vehicle Status");
		System.out.println("6.Driver Details");
		System.out.println("7.Edit Driver Details");
		System.out.println("8.View Bookings");
		System.out.println("9.Exit");
		System.out.println("Enter Choice : ");
	}
	
	@Override
	public boolean addVehicle() {
		
		Vehicle vehicle = new Vehicle();
		
		System.out.println("Enter Vechicle Number : ");
		vehicle.setVehicleNumber(sc.nextLine());
		System.out.println("Enter Vechicle Type : ");
		vehicle.setVehicleType(sc.nextLine());
		System.out.println("Enter Fuel Type : ");
		vehicle.setFuelType(sc.nextLine());
		System.out.println("Enter Insurance Availabe (Yes or No) : ");
		vehicle.setIsInsuranced(sc.nextLine());
		System.out.println("Enter Permit Availabe (Yes or No) : ");
		vehicle.setPermit(sc.nextLine());
		System.out.println("Enter Driver Name : ");
		vehicle.setDriverName(sc.nextLine());
		System.out.println("Enter Driver Number : ");
		vehicle.setDriverMobile(sc.nextLine());
		System.out.println("Enter Availability : ");
		vehicle.setIsAvailable(sc.nextLine());
		
		return objManagerService.addVehicle(vehicle);
	}

	@Override
	public boolean editVehicle(String id,String role) {
		vehicleDetails(id,role);
		System.out.println("Enter VehicleID");
		int vehicleId = s.nextInt();
		System.out.println("Enter Field to Edit(Available or Permit or Insurance)");
		String field = sc.nextLine();
		System.out.println("Enter Updated Data");
		String newData = sc.nextLine();
		return objManagerService.editVehicleDetails(vehicleId, field, newData);
	}
	
	@Override
	public boolean editDriverDetails(String id,String role) {
		driverDetails(id,role);
		System.out.println("Enter VehicleID");
		int vehicleId = s.nextInt();
		System.out.println("Enter new Driver Name");
		String driverName = sc.nextLine();
		System.out.println("Enter Driver Mobile Number");
		String driverMobile = sc.nextLine();
		return objManagerService.editDriverDetails(vehicleId, driverName, driverMobile);
	}

	@Override
	public boolean removeVehicle(String id,String role) {
		vehicleDetails(id,role);
		System.out.println("Enter Vehicle Id to Delete");
		int vehilceId = s.nextInt();
		return objManagerService.removeVehicle(vehilceId);
	}

	@Override
	public void vehicleStatus(String id,String role) {
		String managerBranch = objManagerService.getManagerBranch(id);
		List<List<String>> vehicleDetails = objManagerService.vehicleStatus(managerBranch,role);
		System.out.println("SNO\tVehicleId\tVehicleNumber\tAvailability");
		int cnt=1;
		for (List<String> list : vehicleDetails) {
			System.out.print(cnt+"\t");
			System.out.print(list.get(0) + "\t\t");
			System.out.print(list.get(1) + "\t");
			System.out.print(list.get(2) + "\t\t");
			cnt+=1;
			System.out.println();
		}
	}

	@Override
	public void driverDetails(String id,String role)
	{	
		String managerBranch = objManagerService.getManagerBranch(id);
		List<List<String>> vehicleDetails = objManagerService.driverDetails(managerBranch,role);
		System.out.println("SNO\tVehicleId\tDriverName\tDriverMobile");
		int cnt=1;
		for (List<String> list : vehicleDetails) {
			System.out.print(cnt+"\t");
			System.out.print(list.get(0) + "\t\t");
			System.out.print(list.get(1) + "\t");
			System.out.print(list.get(2) + "\t");
			cnt+=1;
			System.out.println();
		}
	}
	
	@Override
	public void vehicleDetails(String id,String role) {
		String managerBranch = objManagerService.getManagerBranch(id);
		List<List<String>> vehicleDetails = objManagerService.vehicleDetails(managerBranch,role);
		System.out.println("SNO\tVehicleId\tVehicleNumber\tVehicleType\tFuelType\tInsurance\tPermit\tDriverName\tDriverMobile\tAvailability");
		int cnt=1;
		for (List<String> list : vehicleDetails) {
			System.out.print(cnt+"\t");
			System.out.print(list.get(0) + "\t\t");
			System.out.print(list.get(1) + "\t");
			System.out.print(list.get(2) + "\t\t");
			System.out.print(list.get(3) + "\t\t");
			System.out.print(list.get(4) + "\t\t");
			System.out.print(list.get(5) + "\t");
			System.out.print(list.get(6) + "\t");
			System.out.print(list.get(7) + "\t");
			System.out.print(list.get(8) + "\t");
			cnt+=1;
			System.out.println();
		}
	}

	@Override
	public void viewBookings(String managerId,String role)
	{
		String managerBranch = objManagerService.getManagerBranch(managerId);
		List<List<String>> vehicleDetails = objManagerService.viewBookings(managerBranch,role);
		System.out.println("SNO\tbookingId\tuserId\tuserName\tvehicleId\tvehicleType\tvehicleNumber\tbookingDate\treturnDate");
		int cnt=1;
		for (List<String> list : vehicleDetails) {
			System.out.print(cnt+"\t");
			System.out.print(list.get(0) + "\t\t");
			System.out.print(list.get(1) + "\t");
			System.out.print(list.get(2) + "\t\t");
			System.out.print(list.get(3) + "\t\t");
			System.out.print(list.get(4) + "\t\t");
			System.out.print(list.get(5) + "\t");
			System.out.print(list.get(6) + "\t");
			System.out.print(list.get(7) + "\t");
			cnt+=1;
			System.out.println();
		}
	}
}
