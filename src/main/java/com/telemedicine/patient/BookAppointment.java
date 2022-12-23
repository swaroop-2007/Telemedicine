package com.telemedicine.patient;

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


@WebServlet("/BookAppointment")
public class BookAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String apptDate;
	private String apptTime;
    
    public String getApptDate() {
		return apptDate;
	}

	public void setApptDate(String apptDate) {
		this.apptDate = apptDate;
	}

	public String getApptTime() {
		return apptTime;
	}

	public void setApptTime(String apptTime) {
		this.apptTime = apptTime;
	}

	public BookAppointment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String apptDate = request.getParameter("date");
			String apptTime = request.getParameter("time");
			int apt_id = 145425;
			HttpSession session = request.getSession();
			RequestDispatcher dispatcher = null;
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/telemedicine","root","Sql@123456");
				PreparedStatement ps = connection.prepareStatement("select mrn from patient where name='Roger'");
				PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO appointment_reservation(apt_id, date,patient_mrn)values(?,?,?)");
				PreparedStatement preparedStatement1 = connection.prepareStatement("SELECT B.amount, A.apt_id FROM appointment_reservation A JOIN billing_statement B ON A.apt_id=B.apt_id ");
				ResultSet rs = ps.executeQuery();
				int mrn = 0;
				if(rs.next()) {
					mrn = rs.getInt(1);
				}
				preparedStatement.setInt(1, apt_id);
				preparedStatement.setString(2, apptDate);
				preparedStatement.setInt(3, mrn);
				//System.out.println(getApptDate());
				//preparedStatement.setString(2, getApptDate());
				//preparedStatement.setInt(3, 1234);
				//preparedStatement.setInt(4, 14510);
				
				int rowCount = preparedStatement.executeUpdate();
				dispatcher = request.getRequestDispatcher("Bookappt.jsp");
				if(rowCount>0) {
					 request.setAttribute("status", "success");
					
			
				 }
				 else {
					 request.setAttribute("status", "failed");
					dispatcher = request.getRequestDispatcher("Bookappt.jsp");
				 }
				 //response.sendRedirect("/bill");		
				 dispatcher.forward(request, response);

				/*
				ResultSet rs = preparedStatement.executeQuery();
				if(rs.next()) {
					//session.setAttribute("date", rs.getString("username"));
					dispatcher = request.getRequestDispatcher("index.jsp");
				}
				else {
					request.setAttribute("status", "failed");
					dispatcher = request.getRequestDispatcher("login.jsp");
				}
				dispatcher.forward(request,response);
				*/
			} catch (Exception e) {
				e.printStackTrace();
			}
			 
		}

}


