package com.spring.model;

public class Customer {
	private int id;
	private String name;
	private int salary;
	private String dept;

	public Customer() {
		super();
	}

	public Customer(int id,String name, int salary, String dept) {
		this.id = id;
		this.name = name;
		this.salary=salary;
		this.dept=dept;
	}

	public long getId() {
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

	public long getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	

}
