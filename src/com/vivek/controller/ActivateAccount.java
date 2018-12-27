package com.vivek.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vivek.model.MyConnection;

/**
 * Servlet implementation class ActivateAccount
 */
@WebServlet(description = "ActivateAccount", urlPatterns = { "/ActivateAccount" })
public class ActivateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActivateAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String email = request.getParameter("key1");
		String hash = request.getParameter("key2");
		
		Connection con = MyConnection.getConnection();
		
		try {
			PreparedStatement pst = con.prepareStatement("SELECT email, hash, active FROM usertable where email=? AND hash=? AND active='0'");
			pst.setString(1, email);
			pst.setString(2, hash);
			ResultSet rs = pst.executeQuery();
			
				if(rs.next()) {
					PreparedStatement pst1 = con.prepareStatement("UPDATE usertable SET active='1' WHERE email=? AND hash=?");
					pst1.setString(1, email);
					pst1.setString(2, hash);
					
					int i = pst1.executeUpdate();
					if(i==1)
					{
						response.sendRedirect("login.jsp");
					}else {
						response.sendRedirect("index.jsp");
					}
					
				}
			
		}catch(Exception e) {
			System.out.println("ActivateAccount File ::"+e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
