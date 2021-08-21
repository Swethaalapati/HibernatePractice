package com.hibernate.OneToOneRelation;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Student {
	
	@Id
	private int id;
	private String name;
	private String branch;
	
	@OneToOne
	private LaptopDetails laptop;
	

	public Student(int id, String name, String branch, LaptopDetails laptop) {
		
		this.id = id;
		this.name = name;
		this.branch = branch;
		this.laptop = laptop;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", branch=" + branch + "]";
	}
	
}
