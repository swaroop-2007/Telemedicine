package com.telemedicine.doctor;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/DoctorPage")
public class DoctorPage extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DoctorPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/telemedicine","root","Sql@123456");
			
			
			String query="select apt_id, patient_mrn, date from appointment_reservation where doctor_license=93754";
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery(query);
			List<AppointmentReservation> appointments= new ArrayList<AppointmentReservation>();
			
			
			while(rs.next()) {
				String a=rs.getString(1);
				String b=rs.getString(2);
				String c=rs.getString(3);
				//AppointmentReservation ap1=new AppointmentReservation(a,b,c);		

				dispatcher = request.getRequestDispatcher("doctorView.jsp");
				//request.setAttribute("appointments", aptRes); // set your String value in the attribute
				//dispatcher.forward(request,response);
			}
		
			
		
			
		} catch (Exception e) {
			e.printStackTrace();
		
	}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		

}
}
