package com.crud.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.crud.model.Vehicle;

public class ManagerServiceImpl implements ManagerService {
	
	Connection con = DBConnection.getConnection();
	PreparedStatement ps;
	Statement stmt;
	ResultSet rs;

	@Override
	public boolean addVehicle(Vehicle vehicle) {
		
		String sqlQuery = "insert into transport.vehicles(vehicleNumber,vehicleType,fuelType,insurance,permit,driverName,driverMobile,isAvailable) values(?,?,?,?,?,?,?,?)";
	    try
	    {
	      ps = con.prepareStatement(sqlQuery);
	      ps.setString(1, vehicle.getVehicleNumber());
	      ps.setString(2, vehicle.getVehicleType());
	      ps.setString(3, vehicle.getFuelType());
	      ps.setString(4, vehicle.getIsInsuranced());
	      ps.setString(5, vehicle.getPermit());
	      ps.setString(6, vehicle.getDriverName());
	      ps.setString(7, vehicle.getDriverMobile());
	      ps.setString(8, vehicle.getIsAvailable());
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

	@Override
	public boolean editVehicleDetails(int vehicleId, String field, String newData) {
		String sqlQuery = null;
		if(field.equalsIgnoreCase("Available"))
		{
			sqlQuery="update transport.vehicles set isAvailable = ? where vehicleId=?";
		}
		else if(field.equalsIgnoreCase("Permit"))
		{
			sqlQuery="update transport.vehicles set permit = ? where vehicleId=?";
		}
		else if(field.equalsIgnoreCase("insurance"))
		{
			sqlQuery="update transport.vehicles set insurance = ? where vehicleId=?";
		}
		
		try
		{
		ps = con.prepareStatement(sqlQuery);
		ps.setString(1,newData);
		ps.setInt(2,vehicleId);
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
	public boolean editDriverDetails(int vehicleId, String newDriver, String phoneNumber) {
		String sqlQuery="update transport.vehicles set driverName = ? , driverMobile = ? where vehicleId=?";
		try
		{
		ps = con.prepareStatement(sqlQuery);
		ps.setString(1,newDriver);
		ps.setString(2,phoneNumber);
		ps.setInt(3,vehicleId);
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
	public boolean removeVehicle(int vehicleId) {
		String sqlQuery = "delete from transport.vehicles where vehicleId = ?";
		try {
			ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, vehicleId);
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
	public List<List<String>> vehicleStatus(String managerBranch,String role) {
		List<List<String>> vehicleDetails = new ArrayList<List<String>>();
		List<String> vehicle;
		String sqlQuery = null;
		if(role.equalsIgnoreCase("admin"))
			sqlQuery = "select vehicleId, vehicleNumber, isAvailable from transport.vehicles";
		else
			sqlQuery = "select vehicleId, vehicleNumber, isAvailable from transport.vehicles where vehicleType = ?";
		try
		{
			ps = con.prepareStatement(sqlQuery);
			if(role.equalsIgnoreCase("admin"))
			{}	
			else
				ps.setString(1, managerBranch);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				vehicle = new ArrayList<String>();
				vehicle.add(Integer.toString(rs.getInt(1)));
				vehicle.add(rs.getString(2));
				vehicle.add(rs.getString(3));
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
	public List<List<String>> vehicleDetails(String managerBranch,String role) {
		List<List<String>> vehicleDetails = new ArrayList<List<String>>();
		List<String> vehicle;
		String sqlQuery = null;
		if(role.equalsIgnoreCase("admin"))
			sqlQuery = "select * from transport.vehicles";
		else
			sqlQuery = "select * from transport.vehicles where vehicleType = ?";
		try
		{
			ps = con.prepareStatement(sqlQuery);
			if(role.equalsIgnoreCase("admin"))
			{}	
			else
				ps.setString(1, managerBranch);
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
	public List<List<String>> driverDetails(String managerBranch,String role) {
		List<List<String>> driverDetails = new ArrayList<List<String>>();
		List<String> driver;
		String sqlQuery = null;
		if(role.equalsIgnoreCase("admin"))
			sqlQuery = "select * from transport.vehicles";
		else
			sqlQuery = "select * from transport.vehicles where vehicleType = ?";
		try
		{
			ps = con.prepareStatement(sqlQuery);
			if(role.equalsIgnoreCase("admin"))
			{}	
			else
				ps.setString(1, managerBranch);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				driver = new ArrayList<String>();
				driver.add(Integer.toString(rs.getInt(1)));
				driver.add(rs.getString(7));
				driver.add(rs.getString(8));
				driverDetails.add(driver);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return driverDetails;
	}
	
	@Override
	public String getManagerBranch(String managerId)
	{
		String managerBranch = "";
		String sqlQuery = "select managerBranch from transport.managers where userId = ?";
		int mId = Integer.parseInt(managerId);
		try
		{
			ps = con.prepareStatement(sqlQuery);
			ps.setInt(1, mId);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				managerBranch+=rs.getString(1);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return managerBranch;
	}
	
	@Override
	public List<List<String>> viewBookings(String managerBranch,String role) {
		List<List<String>> bookingDetails = new ArrayList<List<String>>();
		List<String> booking;
		String sqlQuery = null;
		if(role.equalsIgnoreCase("admin"))
			sqlQuery = "select * from transport.bookings";
		else
			sqlQuery = "select * from transport.bookings where vehicleType = ?";
		try
		{
			ps = con.prepareStatement(sqlQuery);
			if(role.equalsIgnoreCase("admin"))
			{}	
			else
				ps.setString(1, managerBranch);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				booking = new ArrayList<String>();
				booking.add(Integer.toString(rs.getInt(1)));
				booking.add(Integer.toString(rs.getInt(2)));
				booking.add(rs.getString(3));
				booking.add(rs.getString(4));
				booking.add(rs.getString(5));
				booking.add(rs.getString(6));
				booking.add(rs.getString(7));
				if(rs.getString(8)==null)
					booking.add("-");
				else
					booking.add(rs.getString(8));
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
