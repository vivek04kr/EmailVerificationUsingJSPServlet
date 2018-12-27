package com.vivek.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import com.vivek.model.RegisterBean;
import com.vivek.model.RegisterDAO;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet(description = "RegisterServlet", urlPatterns = { "/RegisterServlet" })
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		///doGet(request, response);
		
		try {
				String fname = request.getParameter("fname");
				String lname = request.getParameter("lname");
				String email = request.getParameter("email");
				String pword = request.getParameter("pword");
				String newpword = DigestUtils.md5Hex(pword); //from commons-codec-1.7.jar
				
			//Generate Hash Code which helps in Activation Link
				
				String myHash;
				Random random = new Random();
				random.nextInt(999999);
				myHash = DigestUtils.md5Hex(""+random);
				
			// Create Data Bean
				
				RegisterBean rb = new RegisterBean();
				rb.setFname(fname);
				rb.setLname(lname);
				rb.setEmail(email);
				rb.setPword(newpword);
				rb.setMyHash(myHash);
				
			// Create DAO File
				RegisterDAO regDao = new RegisterDAO();
				String str = regDao.RegisterUser(rb);
				
				System.out.println("hello");
				if(str.equals("SUCCESS")) {
					response.sendRedirect("verify.jsp");
				}else {
					response.sendRedirect("index.jsp");
				}
				
		}catch(Exception e) {
			System.out.println("RegisterDAO File"+e);
		}
	}

}
