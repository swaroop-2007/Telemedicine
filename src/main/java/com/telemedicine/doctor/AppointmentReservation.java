package com.telemedicine.doctor;

public class AppointmentReservation {
	public String patient_mrn;
	public String apt_id;
	public String date;
	
	public AppointmentReservation(String p, String a, String d) {
		patient_mrn=p;
		apt_id=a;
		date=d;
	}
//	public static void setPatient_mrn(String pmrn) {
//		patient_mrn=pmrn;
//	}
//	public void setApt_id(String a) {
//		apt_id=a;
//	}
//	public void setDate(String d) {
//		date=d;
//	}
}
