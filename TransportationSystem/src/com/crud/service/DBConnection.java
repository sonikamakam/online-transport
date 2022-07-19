package com.crud.service;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection getConnection()
	{
		Connection con = null;
		
        try {


            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/transport?autoReconnect=true&useSSL=false", "root","root");
            
		} catch (Exception e) {
			System.out.println(" Exception during DB Connection "+e);
		}
		return con;
	}	
}