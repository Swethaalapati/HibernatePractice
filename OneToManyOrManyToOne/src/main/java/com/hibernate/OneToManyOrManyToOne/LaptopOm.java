package com.hibernate.OneToManyOrManyToOne;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LaptopOm {

	@Id
	private int lid;
	private String lname;
	
	@ManyToOne
	private StudentOm student;
	
	public LaptopOm(int lid, String lname, StudentOm student) {
		
		this.lid = lid;
		this.lname = lname;
		this.student = student;
		
	}


	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}
	
	public StudentOm getStudent() {
		return student;
	}

	public void setStudent(StudentOm student) {
		this.student = student;
	}
	

	@Override
	public String toString() {
		return "LaptopDetails [lid=" + lid + ", lname=" + lname + " student = " + student +"]";
	}
}
