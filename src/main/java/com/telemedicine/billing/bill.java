package com.telemedicine.billing;

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
 * Servlet implementation class bill
 */
@WebServlet("/bill")
public class bill extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	int total_amount;
	int appt_id;
	String update_amt;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bill() {
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
			
			String query1="select sum(fee) from service where apt_reservation_id=145412";
			PreparedStatement pst1 = con.prepareStatement("select sum(fee) from service where apt_reservation_id=145415");
			ResultSet rs1 = pst1.executeQuery(query1);
			while(rs1.next()) {
				//System.out.println(rs1.getString(1));
				update_amt=rs1.getString(1);
				System.out.println(update_amt);
				
			}
			
			String query="update billing_statement set amount="+update_amt+" where apt_id=145415";
			PreparedStatement pst = con.prepareStatement("update billing_statement set amount="+update_amt+" where apt_id=145415");
			pst.executeUpdate(query);
			
			
			String query2="select amount from billing_statement where apt_id=145412";
			PreparedStatement pst2 = con.prepareStatement("select amount from billing_statement where apt_id=145412");
			ResultSet rs2 = pst2.executeQuery(query2);
			
			while(rs2.next()) {
				String final_amount=rs2.getString(1);
				System.out.println(final_amount);
				dispatcher = request.getRequestDispatcher("bill.jsp");
				request.setAttribute("final_amount", final_amount); // set your String value in the attribute
				dispatcher.forward(request,response);
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
