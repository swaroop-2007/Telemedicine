package com.telemedicine.patient;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/BookAppt")
public class BookAppt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ApptDao apptDao;

    public BookAppt() {
        apptDao = new ApptDao();
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		String apptDate = request.getParameter("date");
		String apptTime = request.getParameter("time");
		ApptBean apptbean = new ApptBean();
		apptbean.setApptDate(apptDate);
		apptbean.setApptTime(apptTime);
		response.sendRedirect("Bookappt.jsp");
		
		try {
			if(apptDao.validate(apptbean)) {
				response.sendRedirect("Bookappt.jsp");
			}
			else {
				HttpSession session = request.getSession();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
       
 