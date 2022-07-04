package com.crud.model;

public class Manager {
	private String role;
	private String branch;
	
	private int id;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Manager(String role, String branch, int id) {
		super();
		this.role = role;
		this.branch = branch;
		this.id = id;
	}
	
}