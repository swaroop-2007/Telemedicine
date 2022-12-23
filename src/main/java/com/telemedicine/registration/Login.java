package com.telemedicine.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/telemedicine","root","Sql@123456");
			PreparedStatement pst = con.prepareStatement("select * from system_user where username = ? and password = ? ");
			pst.setString(1, username);
			pst.setString(2, password);
			PreparedStatement pst1 = con.prepareStatement("select name from system_user where name in(select name from patient)");
			PreparedStatement pst2 = con.prepareStatement("select name from system_user where name in(select fname from doctor)");
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				String un = rs.getString("username");
				session.setAttribute("name", un);
				if (un.equals("swud")) {
					dispatcher = request.getRequestDispatcher("patientView.jsp");
				} else if (un.equals("nehar")) {
					dispatcher = request.getRequestDispatcher("doctorView.jsp");
				} else {
					
				}
			}
			else {
				request.setAttribute("status", "failed");
				dispatcher = request.getRequestDispatcher("login.jsp");
			}
			dispatcher.forward(request,response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
	}

}
