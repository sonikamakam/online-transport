package com.crud.ui;

import java.util.Scanner;

import com.crud.exception.InvalidMobileNumberException;
import com.crud.model.User;
import com.crud.view.AdminModule;
import com.crud.view.AdminModuleImpl;
import com.crud.view.ClientModule;
import com.crud.view.ClientModuleImpl;
import com.crud.view.ManagerModule;
import com.crud.view.ManagerModuleImpl;
import com.crud.view.UserModule;
import com.crud.view.UserModuleImpl;

public class TransportationSystem 
{
	static Scanner sc = new Scanner(System.in);
	static Scanner s = new Scanner(System.in);
	
	static UserModule objUserModule = new UserModuleImpl();
	public static boolean validate(String userName,String password)
	{
		if(userName.equalsIgnoreCase("admin")&& password.equalsIgnoreCase("admin"))
			{
			return true;
			}else
				return false;
	}
	public static void main(String[] args) throws Exception
	{
		try
		{
			System.out.println("Transportation System");
			
			System.out.print("1.Register\n2.Login User\nEnter choice:");
			String userName=null,password=null;
			int ch = s.nextInt();
			if(ch==1)
			{
				System.out.println("Registering User.........");
				System.out.println("UserName : ");
			    userName = sc.nextLine();
			    System.out.println("Password : ");
			    password = sc.nextLine();
			    System.out.println("FirstName : ");
			    String firstName = sc.nextLine();
			    System.out.println("LastName : ");
			    String lastName = sc.nextLine();
			    System.out.println("Email : ");
			    String emailId = sc.nextLine();
			    System.out.println("PhoneNumber : ");
			    String phoneNumber = sc.nextLine();
			    if(phoneNumber.length()!=10)
			    	throw new InvalidMobileNumberException();
			    User reg = new User(userName,password,firstName,lastName,emailId,phoneNumber,0);
			    boolean regStatus = objUserModule.userCreation(reg);
				System.out.println("User Created "+regStatus);
			}
			else if(ch==2)
			{
				System.out.print("Enter User-Name:");
				userName = sc.nextLine();
				System.out.print("Enter Password:");
				password = sc.nextLine();
			}
			String userCred[] = objUserModule.validateUser(userName, password);
			if(userCred!=null)
			{
				String role = userCred[0];
				String id = userCred[1];
				
				if(role.equalsIgnoreCase("manager"))
				{
					boolean running = true;
					while(running)
					{
						ManagerModule objManagerModule = new ManagerModuleImpl(userName);
						int managerChoice = s.nextInt();
						switch(managerChoice)
						{
						case 1:
							boolean vehicleCreated = objManagerModule.addVehicle();
							if(vehicleCreated)
								System.out.println("Vehicle Added Sucessfully........");
							break;
						case 2:
							if(objManagerModule.editVehicle(id,role))
								System.out.println("Vehicle Details Edited Sucessfully");
							else
								System.out.println("Error in Editing Vehicle Details");
							break;
						case 3:
							if(objManagerModule.removeVehicle(id,role))
								System.out.println("Vehicle Removed Sucessfully");
							else
								System.out.println("Error in Removing Vehicle");
							break;
						case 4:
							objManagerModule.vehicleDetails(id,role);
							break;
						case 5:
							objManagerModule.vehicleStatus(id,role);
							break;
						case 6:
							objManagerModule.driverDetails(id, role);
							break;
						case 7:
							if(objManagerModule.editDriverDetails(id,role))
								System.out.println("Driver Details Edited Sucessfully");
							else
								System.out.println("Error in Editing Driver Details");
							break;
						case 8:
							objManagerModule.viewBookings(id,role);
							break;
						case 9:
							System.out.println("Application Closed Successfully");
							running = false;
							System.exit(0);
						}
					}
				}
				else if(validate(userName,password)) {
					
					
						boolean running = true;
						while(running)
						{
							AdminModule objAdminModule = new AdminModuleImpl(userName);
							int adminChoice = s.nextInt();
							switch(adminChoice)
							{
							case 1:
								boolean managerCreated = objAdminModule.newManager();
								if(managerCreated)
									System.out.println("manager created");
								break;
							case 2:
								if(objAdminModule.editManagerDetails())
									System.out.println("Manager Details Edited Sucessfully");
								else
									System.out.println("Error in Editing Manager Details");
								break;
							case 3:
								if(objAdminModule.removeManager())
									System.out.println("Manager Removed Sucessfully");
								else
									System.out.println("Error in Removing Manager");
								break;
							case 4:
								objAdminModule.getManagerDetails();
								break;
							case 5:
								objAdminModule.getUserDetails();
								break;
							case 6:
								boolean running1 = true;
								while(running1)
								{
									ManagerModule objManagerModule = new ManagerModuleImpl(userName);
									int managerChoice = s.nextInt();
									switch(managerChoice)
									{
									case 1:
										boolean vehicleCreated = objManagerModule.addVehicle();
										if(vehicleCreated)
											System.out.println("Vehicle Added Sucessfully........");
										break;
									case 2:
										if(objManagerModule.editVehicle(id,role))
											System.out.println("Vehicle Details Edited Sucessfully");
										else
											System.out.println("Error in Editing Vehicle Details");
										break;
									case 3:
										if(objManagerModule.removeVehicle(id,role))
											System.out.println("Vehicle Removed Sucessfully");
										else
											System.out.println("Error in Removing Vehicle");
										break;
									case 4:
										objManagerModule.vehicleDetails(id,role);
										break;
									case 5:
										objManagerModule.vehicleStatus(id,role);
										break;
									case 6:
										objManagerModule.driverDetails(id, role);
										break;
									case 7:
										if(objManagerModule.editDriverDetails(id,role))
											System.out.println("Driver Details Edited Sucessfully");
										else
											System.out.println("Error in Editing Driver Details");
										break;
									case 8:
										objManagerModule.viewBookings(id,role);
										break;
									case 9:
										System.out.println("Manager Module Closed Successfully");
										running1 = false;
									}
								}
								break;
							case 7:
								System.out.println("Application Closed Successfully");
								running = false;
								System.exit(0);
							}
						
					}
					
					
				}
				else
				{
					boolean running = true;
					while(running)
					{
						ClientModule objClientModule = new ClientModuleImpl(userName);
						int managerChoice = s.nextInt();
						switch(managerChoice)
						{
						case 1:
							objClientModule.viewVehicleTypes();
							break;
						case 2:
							objClientModule.searchByVehicleType();
							break;
						case 3:
							objClientModule.bookVehicle(id,userName);
							break;
						case 4:
							objClientModule.viewBookings(id);
							break;
						case 5:
							objClientModule.returnVehicle(id);
							break;
						case 6:
							System.out.println("Application Closed Successfully");
							running = false;
							System.exit(0);
						}
					}
				}
		}
		}
		catch(InvalidMobileNumberException e)
		{
			System.out.println(e.getErrorMsg());
		}
	}
}