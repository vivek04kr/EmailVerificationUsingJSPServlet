package com.vivek.model;

import java.sql.Connection;
import java.sql.PreparedStatement;



public class RegisterDAO {
	
	public RegisterDAO() {
		
	}
	
	public String RegisterUser(RegisterBean rb) {
		
		 String fname = rb.getFname();
		 String lname = rb.getLname();
		 String email = rb.getEmail();
		 String pword = rb.getPword();
		 String myHash = rb.getMyHash();
		 
		 Connection con = MyConnection.getConnection();
		 
		 try {
			 String sqlQuery = "insert into usertable (fname,lname,email,pword,hash) values (?,?,?,?,?)";
			 PreparedStatement pst = con.prepareStatement(sqlQuery);
			 pst.setString(1, fname);
			 pst.setString(2, lname);
			 pst.setString(3, email);
			 pst.setString(4, pword);
			 pst.setString(5, myHash);
			 System.out.println("Hello vivek");
			 int i = pst.executeUpdate();
			 
			 if(i!=0) {
				 //Sending Email Code
				 SendingEmail se = new SendingEmail(email,myHash);
				 se.sendMail();
				 
				 return "SUCCESS";
			 }
			 
			 
		 }catch(Exception e) {
			 
		 }
		 return "error";
	}
}
