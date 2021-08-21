package com.hibernate.OneToOneRelation;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class LaptopDetails {

	@Id
	private int lid;
	private String lname;
	
	
	public LaptopDetails(int lid, String lname) {
		
		this.lid = lid;
		this.lname = lname;
		
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
	

	@Override
	public String toString() {
		return "LaptopDetails [lid=" + lid + ", lname=" + lname + "]";
	}
	
		
}
