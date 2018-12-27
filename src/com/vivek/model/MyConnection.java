package com.vivek.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {
	
	static Connection con;
	
	public static Connection getConnection() {
	
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/email_verification","root","root");
		}catch(Exception e) {
			System.out.println("From MyConnection Class"+e);
		}
		return con;
	}

}
