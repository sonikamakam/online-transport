package com.crud.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.crud.model.Manager;

public class ManagerService implements ManagerCrud{
	

	@Override
	public int insertRecord(Manager manager) {
		int result=0;
		try{
			Connection con=ManagerConnection.getConnection();
			
			
			PreparedStatement ps=con.prepareStatement("insert into managerdetails(role, branch,id) values(?,?,?)");
			ps.setString(1,manager.getRole());
			ps.setString(2,manager.getBranch());
			ps.setInt(3,manager.getId());
			result=ps.executeUpdate();
			con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
		return result;
	}

	@Override
	public int updateRecord(Manager manager) {
		int result=0;
		try{
			Connection con=ManagerConnection.getConnection();
			
			
			PreparedStatement ps=con.prepareStatement("update managerdetails set role=?,branch=? where id=?");
			ps.setString(1,manager.getRole());
			ps.setString(2,manager.getBranch());
			ps.setInt(3,manager.getId());
			result=ps.executeUpdate();
			con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
		return result;
	}

	@Override
	public int deleteRecord(int id) {
		int result=0;
		try{
			Connection con=ManagerConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from managerdetails where id=?");
			
			ps.setInt(1,id);
			
			result=ps.executeUpdate();
			con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return result;
	}

	@Override
	public List<Manager> getAllRecords() {
		
		ArrayList<Manager> list=new ArrayList<>();
		try{
		Connection con=ManagerConnection.getConnection();
		
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from managerdetails");
			
						
		while(rs.next()) {
			
			list.add(new Manager(rs.getString(1),rs.getString(2),rs.getInt(3)));
			
		}
		stmt.close();
		con.close();
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Manager getManagerById(int id) {
		
		Manager manager=null;
		try{
			Connection con=ManagerConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("Select * from managerdetails where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery(); 
			if(rs.next())
				manager=new Manager(rs.getString(1),rs.getString(2),rs.getInt(3));
			
			con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return manager;
	}



}