package com.crud.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.crud.exception.WrongCredentialsException;
import com.crud.model.User;

public class UserServiceImpl implements UserService {

	Connection con = DBConnection.getConnection();
	PreparedStatement ps;
	Statement stmt;
	ResultSet rs;
	
	@Override
	public boolean userCreation(User user) throws Exception {
		String sqlQuery = "insert into transport.users(userName,password,firstName,lastName,phoneNumber,emailId, totalBookings,role) values(?,?,?,?,?,?,?,?)";
	    try
	    {
	      ps = con.prepareStatement(sqlQuery);
	      ps.setString(1, user.getUserName());
	      ps.setString(2, user.getPassword());
	      ps.setString(3, user.getFirstName());
	      ps.setString(4, user.getLastName());
	      ps.setString(5, user.getPhoneNumber());
	      ps.setString(6, user.getEmailId());
	      ps.setInt(7, user.getTotalBookings());
	      if(user.getRole()==null)
	    	  user.setRole("user");
	      ps.setString(8, user.getRole());
	      int regStatus = ps.executeUpdate();
	      if(regStatus==1)
	      {
	    	  return true;
	      }
	      return false;
	    }
	    catch(Exception e)
	    {
	    	System.out.println(e);
	    }
	    return false;
	}
	
	public int userIdFromDB(String userName)
	{
		int userID = -1;
		String sqlQuery = "select userid from transport.users where userName = ?";
		try
		{
			ps = con.prepareStatement(sqlQuery);
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				userID = rs.getInt(1);
				
			}
			return userID;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return userID;
	}
	
	@Override
	public boolean checkUserName(String userName) {
		String sqlQuery = "select * from transport.users where userName=?";
		try
		{
			ps = con.prepareStatement(sqlQuery);
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			int count = 0;
			while(rs.next())
			{
				count+=1;
			}
			if(count!=0)
				return false;
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
	}
	
	@Override
	public boolean checkUserEmail(String userEmail) {
		String sqlQuery = "select * from transport.users where email=?";
		try
		{
			ps = con.prepareStatement(sqlQuery);
			ps.setString(1, userEmail);
			ResultSet rs = ps.executeQuery();
			int count = 0;
			while(rs.next())
			{
				count+=1;
			}
			if(count!=0)
				return false;
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
	}

	@Override
	public String[] validateUser(String userName, String password) throws WrongCredentialsException { 
			String[] userCred = new String[2];
			String sqlQuery = "select userName,password,role,userid from transport.users";
			String userNames=null,passwords=null,role=null;
			try
			{
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sqlQuery);
				while(rs.next())
				{
					userNames = rs.getString(1);
					passwords = rs.getString(2);
					
					if(userNames.equals(userName) && passwords.equals(password))
					{
						userCred[0] = rs.getString(3);
						userCred[1] = Integer.toString(rs.getInt(4));
						
						break;
					}
				}
				if(userCred.length==0)
					throw new WrongCredentialsException();
				return userCred;
			}
			
			catch(WrongCredentialsException userNameException)
			{
				System.out.println(userNameException.getErrorMsg());
			}
			catch(Exception e)
			{
				System.out.println("User not found "+e);
			}
			return null;
	}
}
