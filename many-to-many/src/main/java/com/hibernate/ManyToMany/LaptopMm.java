package com.hibernate.ManyToMany;

import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class LaptopMm {

	@Id
	private int lid;
	private String lname;
	
	@ManyToMany
	private List<StudentMm> student;
	
	public LaptopMm(int lid, String lname, List<StudentMm> student) {
		
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
	
	public List<StudentMm> getStudent() {
		return student;
	}

	public void setStudent(List<StudentMm> student) {
		this.student = student;
	}
	

	@Override
	public String toString() {
		return "LaptopDetails [lid=" + lid + ", lname=" + lname + " student = " + student +"]";
	}
}
