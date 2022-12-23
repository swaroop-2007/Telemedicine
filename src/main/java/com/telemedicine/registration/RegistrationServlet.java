package com.telemedicine.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String uname = request.getParameter("username");
		 String name = request.getParameter("name");
		 String email = request.getParameter("email");
		 String password = request.getParameter("pass");
		 String accessLevel = request.getParameter("accesslevel");
		 
		 RequestDispatcher dispatcher = null;
		 Connection con = null;
		 
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/telemedicine","root","Sql@123456");
			 PreparedStatement pst = con.prepareStatement
					 ("insert into system_user(username,name,email,password,access_level)values(?,?,?,?,?)");
			 pst.setString(1, uname);
			 pst.setString(2, name);
			 pst.setString(3, email);
			 pst.setString(4, password);
			 pst.setString(5, accessLevel);
			 
			 int rowCount = pst.executeUpdate();
			 dispatcher = request.getRequestDispatcher("registration.jsp");
			 if(rowCount>0) {
				 request.setAttribute("status", "success");
			 }
			 else {
				 request.setAttribute("status", "failed");
			 }
			 dispatcher.forward(request, response);
			 
			
		} catch (Exception e) {
			 e.printStackTrace();
			 } finally {
				 try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			 }
	}

}
