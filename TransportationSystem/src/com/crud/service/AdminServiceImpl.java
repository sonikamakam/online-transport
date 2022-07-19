package com.crud.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.crud.model.Manager;
import com.crud.model.User;

public class AdminServiceImpl implements AdminService {
	
	Connection con = DBConnection.getConnection();
	PreparedStatement ps;
	Statement stmt;
	ResultSet rs;
	
	UserService objUserService = new UserServiceImpl();
	

	@Override
	public boolean removeManager(int managerId) throws Exception {
		
		String sqlQuery = "delete from transport.managers where managerId = ?";
		try {
			ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, managerId);
			int i = ps.executeUpdate();
			if(i==1)
				return true;
			return false;
		}
		catch(Exception e)
		{
			System.out.println("Error while deleting "+e);
		}
		return false;
	}

	@Override
	public boolean editManagerDetails(int managerId, String field, String newData) throws Exception {
		String sqlQuery = null;
		if(field.equalsIgnoreCase("Branch"))
		{
			sqlQuery="update transport.managers set managerBranch = ? where managerId=?";
		}
		else if(field.equalsIgnoreCase("Role"))
		{
			sqlQuery="update transport.managers set managerRole = ? where managerId=?";
		}
		
		try
		{
		ps = con.prepareStatement(sqlQuery);
		ps.setString(1,newData);
		ps.setInt(2,managerId);
		int i = ps.executeUpdate();
		if(i==1)
			return true;
		return false;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
	}

	@Override
	public boolean addManager(Manager managerDetails,User user) throws Exception {
		user.setRole("manager");
		boolean userStatus = objUserService.userCreation(user);
		if(userStatus)
		{
			int userId = objUserService.userIdFromDB(user.getUserName());
			String sqlQuery = "insert into transport.managers(managerName,managerBranch,managerRole,userId) values(?,?,?,?)";
		    try
		    {
		      ps = con.prepareStatement(sqlQuery);
		      ps.setString(1, managerDetails.getManagerName());
		      ps.setString(2, managerDetails.getManagerBranch());
		      ps.setString(3, managerDetails.getManagerRole());
		      ps.setInt(4, userId);
		      int regStatus = ps.executeUpdate();
		      if(regStatus==1)
		    	  return true;
		      return false;
		    }
		    catch(Exception e)
		    {
		    	System.out.println(e);
		    }
		    return false;
		}
		return false;
	}

	@Override
	public List<List<String>> getManagerDetails() {
		List<List<String>> managerDetails = new ArrayList<List<String>>();
		List<String> manager;
		String sqlQuery = "select * from transport.managers";
		try
		{
			ps = con.prepareStatement(sqlQuery);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				manager = new ArrayList<String>();
				manager.add(Integer.toString(rs.getInt(1)));
				manager.add(rs.getString(2));
				manager.add(rs.getString(3));
				manager.add(rs.getString(4));
				managerDetails.add(manager);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return managerDetails;
	}

	@Override
	public List<List<String>> getUserDetails() {
		List<List<String>> userDetails = new ArrayList<List<String>>();
		List<String> user;
		String sqlQuery = "select * from transport.users where role=?";
		try
		{
			ps = con.prepareStatement(sqlQuery);
			ps.setString(1, "user");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				user = new ArrayList<String>();
				user.add(Integer.toString(rs.getInt(1)));
				user.add(rs.getString(4));
				user.add(rs.getString(5));
				user.add(rs.getString(6));
				user.add(rs.getString(7));
				user.add(rs.getString(8));
				userDetails.add(user);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return userDetails;
	}

	@Override
	public List<List<String>> viewBookings() {
		List<List<String>> bookingDetails = new ArrayList<List<String>>();
		List<String> booking;
		String sqlQuery = "select * from transport.bookings";
		try
		{
			ps = con.prepareStatement(sqlQuery);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				booking = new ArrayList<String>();
				booking.add(Integer.toString(rs.getInt(1)));
				booking.add(Integer.toString(rs.getInt(2)));
				booking.add(rs.getString(3));
				booking.add(rs.getString(5));
				booking.add(rs.getString(6));
				bookingDetails.add(booking);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return bookingDetails;
	}
}
