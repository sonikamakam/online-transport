package com.crud.service;

import java.sql.Connection;
import java.sql.DriverManager;

public class ManagerConnection {
	
		public static Connection getConnection() {
			Connection con=null;
			//Step 1 : load Driver in memory
			try {
				//to call Class loader to load class in memory at dymanic time
				Class.forName("com.mysql.cj.jdbc.Driver");
			
			
				//Step 2: Database information 
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?autoReconnect=true&useSSL=false", "root","root");
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			return con;
			
		}
	}


