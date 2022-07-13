package com.user.view;
import java.util.List;
import java.util.Scanner;

import com.user.controller.UserController;
import com.user.model.User;
public class UserView {
	public static void main(String[] args) throws Exception {
		UserController usercon = new UserController();
		int result;
		User userc = null;
		 int id;
		 String name;
		 String uname;
		 String password;
		 int contactno;
		 int choice;
		
		// Crud Operation Menu
			while(true){
			System.out.println("1. Add Record");
			System.out.println("2. Update Record");
			System.out.println("3. Delete Record");
			System.out.println("4. View Records");
			System.out.println("5. View a Record");
			System.out.println("0. Exit ");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your choice");
			
			 choice = sc.nextInt();
			 
			 switch (choice) {
				case 1:
					System.out.println("Enter id, name,uname,password, contactno");
					sc.nextLine();
					id =sc.nextInt();
					sc.nextLine();
					name=sc.nextLine();
					uname=sc.nextLine();
					password=sc.nextLine();
					
					contactno = sc.nextInt();
					

					userc = new User(id, name,uname,password, contactno);
					System.out.println(userc.toString());
					result = usercon.insertRecord(userc);
					if (result > 0)
						System.out.println("Record Inserted");
					else
						System.out.println("Record not inserted");
					break;
				
				case 2:
					System.out.println("Enter id, name,uname,password, contactno");
					sc.nextLine();
					id =sc.nextInt();
					sc.nextLine();
					name=sc.nextLine();
					uname=sc.nextLine();
					password=sc.nextLine();
					contactno = sc.nextInt();

					userc = new User(id, name,uname,password, contactno);
					result = usercon.updateRecord(userc);
					if (result > 0)
						System.out.println("Record Updated");
					else
						System.out.println("Record not inserted");
					break;
			 

				case 3:
					System.out.println("Enter id");
					sc.nextInt();
					id = sc.nextInt();
					
					result = usercon.deleteRecord(id);
					if (result > 0)
						System.out.println("Record deleted");
					else
						System.out.println("Record not found");
					break;
			 
				case 4:
					List<User> list=usercon.getAllRecords();
					for(User us : list){
						System.out.println(us.getId()+"\t"+us.getName()+" "+us.getUname()+" "+us.getPassword()+" "+us.getContactno());
					}
				break;
				
				case 5:
					System.out.println("Enter id");
					sc.nextInt();
					id = sc.nextInt();
					
					userc=usercon.getUserbyId(id);
					System.out.println("Id="+userc.getId());
					System.out.println("Name="+userc.getName());
					System.out.println("Uname="+userc.getUname());
					System.out.println("Password="+userc.getPassword());
					System.out.println("Contactno="+userc.getContactno());
					break;
				case 0: System.exit(0);
				
			}
    
	}
	}
}