package com.crud.service;
import java.util.List;

import com.crud.model.Manager;

public interface ManagerCrud {
	
	int insertRecord(Manager manger);
	int updateRecord(Manager manager);
	int deleteRecord(int id);
	List<Manager> getAllRecords();
	Manager getManagerById(int id);

}