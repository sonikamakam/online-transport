package com.crud.controller;

import java.util.List;

import com.crud.model.Manager;
import com.crud.service.ManagerService;

public class ManagerController {
	
	ManagerService managerservice;
	
	public ManagerController() {
		managerservice=new ManagerService();
	}


	public int insertRecord(Manager manager) {
		int result=managerservice.insertRecord(manager);
		return result;
	}


	public int updateRecord(Manager manager) {
		
		int result=managerservice.updateRecord(manager);
		return result;
	}

	
	public int deleteRecord(int id) {
		
		int result=managerservice.deleteRecord(id);
		return result;
	}

	
	public List<Manager> getAllRecords() {
		
		List <Manager> list=managerservice.getAllRecords();
		return list;
	}

	
	public Manager getManagerById(int id) {
		
		Manager manager=managerservice.getManagerById(id);
		return manager;
	}


}