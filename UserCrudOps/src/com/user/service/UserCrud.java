package com.user.service;
import java.util.List;
import com.user.model.User;
public interface UserCrud {
	int insertRecord(User user);
	int updateRecord(User user);
	int deleteRecord(int id);
	List<User> getAllRecords();
	User getUserbyId(int id);
	
	
}
