package com.crud.view;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import com.crud.controller.ManagerController;
import com.crud.model.Manager;

public class View {
	public static void main(String[] args) throws Exception {
		ManagerController managerctrl = new ManagerController();
		int result;
		Manager manager = null;
		String role;
		String branch;
		int id;
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
			System.out.println("Enter role, branch, id");
			sc.nextLine();
			role = sc.nextLine();
			branch = sc.nextLine();
			id = sc.nextInt();
			
			

			manager = new Manager(role, branch, id);
			result = managerctrl.insertRecord(manager);
			if (result > 0)
				System.out.println("Record Inserted");
			else
				System.out.println("Record not inserted");
			break;
		case 2:
			System.out.println("Enter role, branch, id");
			sc.nextLine();
			role = sc.nextLine();
			branch = sc.nextLine();
			id = sc.nextInt();
			
			

			manager = new Manager(role, branch, id);
			result = managerctrl.insertRecord(manager);
			result = managerctrl.updateRecord(manager);
			if (result > 0)
				System.out.println("Record updated");
			else
				System.out.println("Record not found");
			break;

		case 3:
			System.out.println("Enter id");
			id = sc.nextInt();
			result = managerctrl.deleteRecord(id);
			if (result > 0)
				System.out.println("Record deleted");
			else
				System.out.println("Record not found");
			break;
		case 4:
			List<Manager> list=managerctrl.getAllRecords();
			for(Manager stud : list){
				System.out.println(stud.getRole()+"\t"+stud.getBranch()+" "+stud.getId());
			}
		break;
		
		case 5:
			System.out.println("Enter id");
			id=sc.nextInt();
			manager=managerctrl.getManagerById(id);
			System.out.println("Role="+manager.getRole());
			System.out.println("Branch="+manager.getBranch());
			System.out.println("Id="+manager.getId());
			break;
		case 0: System.exit(0);

		}
	}
	}
}