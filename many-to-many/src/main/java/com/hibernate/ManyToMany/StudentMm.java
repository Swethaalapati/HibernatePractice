package com.hibernate.ManyToMany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class StudentMm {
	
	@Id
	private int id;
	private String name;
	private String branch;
	
	@ManyToMany(mappedBy="student")
	private List<LaptopMm> laptop;

	public StudentMm(int id, String name, String branch, List<LaptopMm> laptop) {
		
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

	public List<LaptopMm> getLaptop() {
		return laptop;
	}

	public void setLaptop(List<LaptopMm> laptop) {
		this.laptop = laptop;
	}

	@Override
	public String toString() {
		return "StudentOm [id=" + id + ", name=" + name + ", branch=" + branch + ", laptop=" + laptop + "]";
	}
	
	

}
