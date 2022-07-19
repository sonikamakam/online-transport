package com.crud.view;

import java.util.List;
import java.util.Scanner;

import com.crud.exception.InvalidMobileNumberException;
import com.crud.model.Manager;
import com.crud.model.User;
import com.crud.service.AdminService;
import com.crud.service.AdminServiceImpl;

public class AdminModuleImpl implements AdminModule {

	AdminService objAdminService = new AdminServiceImpl(); 
	
	Scanner sc = new Scanner(System.in);
	Scanner s = new Scanner(System.in);

	public AdminModuleImpl() {
		super();
	}
	
	public AdminModuleImpl(String userName) {
		super();
		System.out.println("Welcome Admin " + userName+",");
		System.out.println("1.Add Manager");
		System.out.println("2.Edit Manager Details");
		System.out.println("3.Remove Manager");
		System.out.println("4.Get Manager Details");
		System.out.println("5.Get User Details");
		System.out.println("6.Manager Module");
		System.out.println("7.Exit");
		System.out.println("Enter Choice : ");
	}

	@Override
	public void viewBookings()
	{
		List<List<String>> vehicleDetails = objAdminService.viewBookings();
		System.out.println("SNO\tBookingId\tUserName\tVehicleNumber\tBookingDate");
		int cnt=1;
		for (List<String> list : vehicleDetails) {
			System.out.print(cnt+"\t");
			System.out.print(list.get(0) + "\t\t");
			System.out.print(list.get(1) + "\t");
			System.out.print(list.get(2) + "\t\t");
			System.out.print(list.get(3) + "\t\t");
			System.out.print(list.get(4));
			cnt+=1;
			System.out.println();
		}
	}
	
	@Override
	public boolean removeManager() throws Exception {	
		getManagerDetails();
		System.out.println("Enter ManagerID");
		int managerId = s.nextInt();
		return objAdminService.removeManager(managerId);
	}

	@Override
	public boolean editManagerDetails() throws Exception {
		getManagerDetails();
		System.out.println("Enter ManagerID");
		int managerId = s.nextInt();
		System.out.println("Enter Field to Edit(Branch or Role)");
		String field = sc.nextLine();
		System.out.println("Enter Updated Data");
		String newData = sc.nextLine();
		return objAdminService.editManagerDetails(managerId, field, newData);
	}

	public boolean addManager(Manager managerDetails,User user) throws Exception {
		return objAdminService.addManager(managerDetails,user);
	}

	@Override
	public boolean newManager() throws Exception {
		Manager managerDetails = new Manager();
		User userDetails = new User();
		
		System.out.println("UserName : ");
	    userDetails.setUserName(sc.nextLine());
	    System.out.println("Password : ");
	    userDetails.setPassword(sc.nextLine());
	    System.out.println("FirstName : ");
	    userDetails.setFirstName(sc.nextLine());
	    System.out.println("LastName : ");
	    userDetails.setLastName(sc.nextLine());
	    System.out.println("Email : ");
	    userDetails.setEmailId(sc.nextLine());
	    System.out.println("PhoneNumber : ");
	    userDetails.setPhoneNumber(sc.nextLine());
	    if(userDetails.getPhoneNumber().length()!=10)
	    	throw new InvalidMobileNumberException();
	    userDetails.setTotalBookings(0);
	    
	    String managerName = userDetails.getFirstName() + " " + userDetails.getLastName();
	    
	    managerDetails.setManagerName(managerName);
	    System.out.println("Manager Branch : ");
	    managerDetails.setManagerBranch(sc.nextLine());
	    System.out.println("Manager Role : ");
	    managerDetails.setManagerRole(sc.nextLine());
	    
		return addManager(managerDetails, userDetails);
	}

	@Override
	public void getManagerDetails() {
		
		List<List<String>> managerDetails = objAdminService.getManagerDetails();
		System.out.println("SNO\tManagerId\tManagerName\t\tBranch\tRole");
		int cnt=1;
		for (List<String> list : managerDetails) {
			System.out.print(cnt+"\t");
			System.out.print(list.get(0) + "\t\t");
			System.out.print(list.get(1) + "\t\t");
			System.out.print(list.get(2) + "\t");
			System.out.print(list.get(3) + "\t");
			cnt+=1;
			System.out.println();
		}
	}

	@Override
	public void getUserDetails() {
		
		List<List<String>> userDetails = objAdminService.getUserDetails();
		System.out.println("SNO\tUserId\tFirstName\tLastName\tPhoneNumber\tEmailId\t\t\tBookings");
		int cnt=1;
		for (List<String> list : userDetails) {
			System.out.print(cnt+"\t");
			System.out.print(list.get(0) + "\t");
			System.out.print(list.get(1) + "\t");
			System.out.print(list.get(2) + "\t\t");
			System.out.print(list.get(3) + "\t");
			System.out.print(list.get(4) + "\t");
			System.out.print(list.get(5) + "\t");
			cnt+=1;
			System.out.println();
		}
	}
}
