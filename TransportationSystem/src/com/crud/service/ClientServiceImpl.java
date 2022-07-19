package com.crud.service;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ClientServiceImpl implements ClientService {
	
	Connection con = DBConnection.getConnection();
	PreparedStatement ps;
	Statement stmt;
	ResultSet rs;

	@Override
	public List<List<String>> searchByVehicleType(String type) {
		List<List<String>> vehicleDetails = new ArrayList<List<String>>();
		List<String> vehicle;
		String sqlQuery = "select * from transport.vehicles where vehicleType = ?";
		try
		{
			ps = con.prepareStatement(sqlQuery);
			ps.setString(1, type);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				vehicle = new ArrayList<String>();
				vehicle.add(Integer.toString(rs.getInt(1)));
				vehicle.add(rs.getString(2));
				vehicle.add(rs.getString(3));
				vehicle.add(rs.getString(4));
				vehicle.add(rs.getString(5));
				vehicle.add(rs.getString(6));
				vehicle.add(rs.getString(7));
				vehicle.add(rs.getString(8));
				vehicle.add(rs.getString(9));
				vehicleDetails.add(vehicle);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return vehicleDetails;
	}

	@Override
	public List<List<String>> viewVehicleTypes() {
		List<List<String>> vehicleTypes = new ArrayList<List<String>>();
		List<String> vehicle;
		String sqlQuery = "select * from transport.vehicles";
		try
		{
			ps = con.prepareStatement(sqlQuery);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				vehicle = new ArrayList<String>();
				vehicle.add(rs.getString(3));
				vehicleTypes.add(vehicle);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return vehicleTypes;
	}

	public boolean changeVehicleStatus(int vehicleID,String status)
	{
		String sqlQuery = "update transport.vehicles set isAvailable = ? where vehicleId = ?";
	    try
	    {
	      ps = con.prepareStatement(sqlQuery);
	      ps.setString(1, status);
	      ps.setInt(2, vehicleID);
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
	public String[] getVehicleDetails(int vehicleId)
	{
		String[] details = new String[3];
		String sqlQuery = "select vehicleId,vehicleType,vehicleNumber from transport.vehicles where vehicleId = ?";
		try
		{
			ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, vehicleId);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				details[0] = Integer.toString(rs.getInt(1));
				details[1] = rs.getString(2);
				details[2] = rs.getString(3);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return details;
	}
	@Override
	public boolean bookVehicle(int vehicleId,int userId, String userName) {
		String vehicleDetails[] = getVehicleDetails(vehicleId);
		String sqlQuery = "insert into transport.bookings(userId, userName, vehicleId, vehicleType, vehicleNumber, bookingDate) values(?,?,?,?,?,?)";
	    try
	    {
	      ps = con.prepareStatement(sqlQuery);
	      ps.setInt(1,userId);
	      ps.setString(2,userName);
	      ps.setInt(3,Integer.parseInt(vehicleDetails[0]));
	      ps.setString(4,vehicleDetails[1]);
	      ps.setString(5,vehicleDetails[2]);
	      Date date = new Date();  
	      SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
	      String strDate = formatter.format(date);  
	      ps.setString(6,strDate);
	      int regStatus = ps.executeUpdate();
	      if(regStatus==1)
	      {
	    	  if(changeVehicleStatus(vehicleId, "No"))
	    		  return true;
	    	  return false;
	      }
	      return false;
	    }
	    catch(Exception e)
	    {
	    	System.out.println(e);
	    }
	    return false;
	}
	
	public int vehicleIDfromBookings(int bookingId)
	{
		String query = "select vehicleId from transport.bookings where bookingId = ?";
		int vehicleId = -1;
		try
	    {
	      ps = con.prepareStatement(query);
	      ps.setInt(1,bookingId);
	      ResultSet rs = ps.executeQuery();
	      while(rs.next())
	      {
	    	  vehicleId = rs.getInt(1);
	      }
	    }
	    catch(Exception e)
	    {
	    	System.out.println(e);
	    }
	    return vehicleId;
		
	}
	
	@Override
	public boolean returnVehicle(int bookingId)
	{
		int vehicleId = vehicleIDfromBookings(bookingId);
		 
		String sqlQuery = "update transport.bookings set returnDate = ? where bookingId = ?";
	    try
	    {
	      ps = con.prepareStatement(sqlQuery);
	      Date date = new Date();  
	      SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
	      String strDate = formatter.format(date);  
	      ps.setString(1,strDate);
	      ps.setInt(2, bookingId);
	      int regStatus = ps.executeUpdate();
	      if(regStatus==1)
	      {
	    	  if(changeVehicleStatus(vehicleId, "Yes"))
	    		  return true;
	    	  return false;
	      }
	      return false;
	    }
	    catch(Exception e)
	    {
	    	System.out.println(e);
	    }
	    return false;
	}
	
	@Override
	public List<List<String>> viewBookings(int userID)
	{
		List<List<String>> bookings = new ArrayList<List<String>>();
		List<String> booking;
		String sqlQuery = "select * from transport.bookings where userId = ?";
		try
		{
			ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, userID);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				booking = new ArrayList<String>();
				booking.add(Integer.toString(rs.getInt(1)));
				booking.add(Integer.toString(rs.getInt(4)));
				booking.add(rs.getString(6));
				booking.add(rs.getString(7));
				if(rs.getString(8)==null)
					bookings.add(booking);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return bookings;
	}
}
