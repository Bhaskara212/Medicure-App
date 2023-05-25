package com.Krishna.com.Healthcareapp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Doctor {
	
	@Id
	private int doctorId;
	private String doctorName;
	private String specialist ;
	private long dmobileNo;
	
	public Doctor() {
	
	}
	
	public Doctor(int doctorId,String doctorName,String specialist,long dmobileNo){
	this.doctorId=doctorId;
	this.doctorName=doctorName;
	this.specialist=specialist;
	this.dmobileNo=dmobileNo;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getSpecialist() {
		return specialist;
	}

	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}

	public long getDmobileNo() {
		return dmobileNo;
	}

	public void setDmobileNo(long dmobileNo) {
		this.dmobileNo = dmobileNo;
	}	
	

}
