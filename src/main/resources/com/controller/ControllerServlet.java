package com.controller;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.operations.SaveUser;
import com.pojo.UserPojo;


public class ControllerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		try {
			String userid =req.getParameter("userCode");
			int id= Integer.parseInt(userCode);
			String userSurname=req.getParameter("userSurame");
			String birthday=req.getParameter("birthday");//getting all the values from user
			String email=req.getParameter("email");
			String password=req.getParameter("password");

			//getting all the values from index.jsp
			
			UserPojo pObject = new UserPojo();
			pObject.setId(id);
			pObject.setUsername(username);		//setting up the received values from index.jsp to setters and getters
			pObject.setPass(pass);
			pObject.setEmail(email);
			
			
			
			int status = SaveUser.save(pObject); // sending the pObject values to save method
			if(status>0){
			//executes if the details are added to database
				out.print("<h2 align='center'>SuccessFully Registered</h2>"); // if successfully executes save method
				out.print("<a align='center'href='login.jsp'>Login Here</a>");
				
				
			}else{
				req.getRequestDispatcher("index.jsp").include(req, resp);
				out.print("<p>User Already Exists with Same User Details</p>");

				//this executes if user is already exists
			}
			
		}catch(Exception e){
			req.getRequestDispatcher("index.jsp").include(req, resp);

			out.print("<p>Enter Valid Details to Register</p>");
			// executes if at all user enters invalid details
		}		
	}
}