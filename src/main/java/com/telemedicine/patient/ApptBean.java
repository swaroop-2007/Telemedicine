package com.telemedicine.patient;

public class ApptBean {
	private static final long serialVersionUID = 1L;
	private String apptDate;
	private String apptTime;

    public ApptBean() {
        // TODO Auto-generated constructor stub
    }
	
	public void setApptDate(String date) {
		apptDate = date;
	}
	
	public void setApptTime(String time) {
		apptDate = time;
	}
	
	public String getApptDate() {
		return apptDate;
	}
	
	public String getApptTime() {
		return apptTime;
	}

}
